package com.fsck.k9.ui.settings.notifications.view

import com.fsck.k9.ui.settings.notifications.model.ItemsManager
import com.fsck.k9.ui.settings.notifications.model.NotificationAction

fun crateItems(): List<ItemsManager.Item> =
    listOf(ItemsManager.Item.HeaderOne(), ItemsManager.Item.HeaderTwo()).plus(
        getNotifications()
    )

private fun getNotifications(): List<ItemsManager.Item.Notification> {
    return "ABCDEFGHILMONPQRSTUVZ".toList().map {
        NotificationAction(it.toString(), it.toString().toLowerCase())
    }.map { ItemsManager.Item.Notification(it) }
}
