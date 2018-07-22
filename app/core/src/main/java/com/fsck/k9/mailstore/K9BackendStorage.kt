package com.fsck.k9.mailstore

import android.content.ContentValues
import com.fsck.k9.Account
import com.fsck.k9.Preferences
import com.fsck.k9.backend.api.BackendFolder
import com.fsck.k9.backend.api.BackendStorage
import com.fsck.k9.backend.api.FolderInfo

class K9BackendStorage(
        private val preferences: Preferences,
        private val account: Account,
        private val localStore: LocalStore
) : BackendStorage {
    private val database = localStore.database

    override fun getFolder(folderServerId: String): BackendFolder {
        return K9BackendFolder(preferences, account, localStore, folderServerId)
    }

    override fun getFolderServerIds(): List<String> {
        return database.query("folders", arrayOf("server_id"), "server_id != ?", account.outboxFolder) { cursor ->
            val folderServerIds = mutableListOf<String>()
            while (cursor.moveToNext()) {
                folderServerIds.add(cursor.getString(0))
            }

            folderServerIds
        }
    }

    override fun createFolders(folders: List<FolderInfo>) {
        if (folders.isEmpty()) return

        val localFolders = folders.map { localStore.getFolder(it.serverId, it.name) }
        localStore.createFolders(localFolders, account.displayCount)
    }

    override fun deleteFolders(folderServerIds: List<String>) {
        folderServerIds.asSequence()
                .filterNot { account.isSpecialFolder(it) }
                .map { localStore.getFolder(it) }
                .forEach { it.delete() }
    }

    override fun changeFolder(folderServerId: String, name: String) {
        database.execute(false) { db ->
            val values = ContentValues().apply {
                put("name", name)
            }

            db.update("folders", values, "server_id = ?", arrayOf(folderServerId))
        }
    }
}
