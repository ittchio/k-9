package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.fsck.k9.ui.R


class DragAndDropAdapter : RecyclerView.Adapter<DragAndDropViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val mView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.drag_and_drop_item, parent, false)
        return DragAndDropViewHolder(mView)
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {

    }
}