package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.fsck.k9.ui.R
import com.fsck.k9.ui.settings.notifications.model.ItemsManager

sealed class NotificationsActionsViewHolder<in T : ItemsManager.Item>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    abstract fun bind(notificationAction: T)

    class Normal(itemView: View) :
        NotificationsActionsViewHolder<ItemsManager.Item.Notification>(itemView) {

        private var title: TextView
        private var description: TextView

        init {
            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
        }

        override fun bind(notificationAction: ItemsManager.Item.Notification) {
            title.text = notificationAction.action.name
            description.text = notificationAction.action.description
        }
    }

    class Header(itemView: View) :
        NotificationsActionsViewHolder<ItemsManager.Item.Header>(itemView) {

        private var title: TextView
        private var subtitle: TextView

        init {
            title = itemView.findViewById(R.id.title)
            subtitle = itemView.findViewById(R.id.subtitle)
        }

        override fun bind(header: ItemsManager.Item.Header) {
            title.text = header.title
            subtitle.text = header.description
        }
    }
}