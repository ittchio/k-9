package com.fsck.k9.ui.settings.notifications.model

interface ItemsManager {
    val count: Int

    operator fun get(position: Int): ItemsManager.Item

    fun moveIsSucessful(fromPosition: Int, toPosition: Int): Boolean

    fun getItemViewType(position: Int): Int

    sealed class Item {
        class Notification(val action: NotificationAction) : Item()

        sealed class Header(val title: String, val description: String) : Item() {
            class HeaderOne(title: String, description: String) : Header(title, description)
            class HeaderTwo(title: String, description: String) : Header(title, description)
        }
    }
}