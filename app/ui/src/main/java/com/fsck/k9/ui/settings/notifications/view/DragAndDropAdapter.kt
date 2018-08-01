package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fsck.k9.ui.R
import com.fsck.k9.ui.settings.notifications.model.ItemsManagerManagerImpl


class DragAndDropAdapter(private val notifications: ItemsManagerManagerImpl) :
    RecyclerView.Adapter<DragAndDropViewHolder>() {

    val itemTouchHelperCallback = object : ItemTouchHelperCallback<DragAndDropViewHolder>() {
        override fun onMove(
            recyclerView: RecyclerView?,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ) = onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition())
    }

    override fun getItemCount() = notifications.count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        val view = layoutInflater.inflate(R.layout.drag_and_drop_item, parent, false)
        return DragAndDropViewHolder(view)
    }

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {
        holder.bind(notifications[position])
    }
    
    private fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean {
        notifyItemMoved(fromPosition, toPosition);
        return true
    }
}