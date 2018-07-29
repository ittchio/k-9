package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fsck.k9.ui.R


class DragAndDropAdapter : RecyclerView.Adapter<DragAndDropViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        val view = layoutInflater.inflate(R.layout.drag_and_drop_item, parent, false)
        return DragAndDropViewHolder(view)
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {

    }
}