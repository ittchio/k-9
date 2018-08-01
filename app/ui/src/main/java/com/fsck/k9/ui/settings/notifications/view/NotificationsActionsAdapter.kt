package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.fsck.k9.ui.settings.notifications.model.ItemsManager
import com.fsck.k9.ui.settings.notifications.model.NotificationActionsViewHolderCreator

class NotificationsActionsAdapter(
    private val itemsManager: ItemsManager,
    private val viewHolderCreator: NotificationActionsViewHolderCreator
) :
    RecyclerView.Adapter<NotificationsActionsViewHolder<ItemsManager.Item>>() {

    val itemTouchHelperCallback =
        object : ItemTouchHelperCallback<NotificationsActionsViewHolder<ItemsManager.Item>>() {
            override fun onMove(
                recyclerView: RecyclerView?,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition())
        }

    override fun getItemCount() = itemsManager.count

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationsActionsViewHolder<ItemsManager.Item> =
        viewHolderCreator.createHolder(parent, viewType)

    override fun onBindViewHolder(
        holder: NotificationsActionsViewHolder<ItemsManager.Item>,
        position: Int
    ) = holder.bind(itemsManager[position])

    private fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean {
        if (itemsManager.moveIsSucessful(fromPosition, toPosition)) {
            notifyItemMoved(fromPosition, toPosition);
            return true
        }
        return false
    }

    override fun getItemViewType(position: Int) = itemsManager.getItemViewType(position)

    class ViewType {
        companion object {
            @JvmField
            val NORMAL = 0
            @JvmField
            val HEADER_1 = 1
            @JvmField
            val HEADER_2 = 2
        }
    }
}