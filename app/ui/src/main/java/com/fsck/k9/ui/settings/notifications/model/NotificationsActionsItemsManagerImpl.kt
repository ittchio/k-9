package com.fsck.k9.ui.settings.notifications.model

import com.fsck.k9.ui.settings.notifications.view.DragAndDropAdapter
import com.fsck.k9.ui.settings.notifications.view.crateItems

class ItemsManagerManagerImpl : ItemsManagerManager {

    private var items: List<NotificationAction> = crateItems()

    override val count: Int
        get() = items.size

    override operator fun get(position: Int): NotificationAction = items[position]

    override fun moveIsSucessful(fromPosition: Int, toPosition: Int): Boolean {
        return true
    }

    override fun getItemViewType(position: Int): Int {
        return DragAndDropAdapter.ViewType.NORMAL
    }
}