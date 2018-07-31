package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.fsck.k9.ui.settings.notifications.model.NotificationAction
import kotlinx.android.synthetic.main.drag_and_drop_item.view.*

class DragAndDropViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(notificationAction: NotificationAction) {
        itemView.title.text = notificationAction.name
        itemView.description.text = notificationAction.description
    }
}