package com.fsck.k9.ui.settings.notifications.model

import com.fsck.k9.ui.settings.notifications.view.NotificationsActionsAdapter
import com.fsck.k9.ui.settings.notifications.view.crateItems

class ItemsManagerImpl(private val itemsMover: ItemsMover) : ItemsManager {

    private var items: List<ItemsManager.Item> = crateItems()

    override val count: Int
        get() = items.size

    override operator fun get(position: Int) = items[position]

    override fun moveIsSucessful(fromPosition: Int, toPosition: Int) =
        itemsMover.moveIsSucessful(items[fromPosition], items[toPosition])

    override fun getItemViewType(position: Int): Int {
        return NotificationsActionsAdapter.ViewType.NORMAL
    }
}