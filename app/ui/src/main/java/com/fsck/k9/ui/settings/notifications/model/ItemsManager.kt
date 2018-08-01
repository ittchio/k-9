package com.fsck.k9.ui.settings.notifications.model

interface ItemsManager {
    val count: Int

    operator fun get(position: Int): ItemsManager.Item

    fun moveIsSucessful(fromPosition: Int, toPosition: Int): Boolean

    fun getItemViewType(position: Int): Int

    sealed class Item {
        class Notification(val action: NotificationAction) : Item()
        class HeaderOne : Item()
        class HeaderTwo : Item()
    }
}