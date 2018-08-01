package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fsck.k9.ui.R
import com.fsck.k9.ui.settings.notifications.model.ItemsManagerManager
import com.fsck.k9.ui.settings.notifications.model.ViewHolderCreator

class DragAndDropAdapter(
    private val itemsManager: ItemsManagerManager,
    private val vievHolderCreator: ViewHolderCreator
) :
    RecyclerView.Adapter<DragAndDropViewHolder>() {

    val itemTouchHelperCallback = object : ItemTouchHelperCallback<DragAndDropViewHolder>() {
        override fun onMove(
            recyclerView: RecyclerView?,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ) = onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition())
    }

    override fun getItemCount() = itemsManager.count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        val view = layoutInflater.inflate(R.layout.drag_and_drop_item, parent, false)
        return DragAndDropViewHolder(view)
    }

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {
        holder.bind(itemsManager[position])
    }

    private fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean {
        if (itemsManager.moveIsSucessful(fromPosition, toPosition)) {
            notifyItemMoved(fromPosition, toPosition);
            return true
        }
        return false
    }

    override fun getItemViewType(position: Int) = itemsManager.getItemViewType(position)

    companion object {
        private val TAG = DragAndDropAdapter::class.simpleName!!
    }

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