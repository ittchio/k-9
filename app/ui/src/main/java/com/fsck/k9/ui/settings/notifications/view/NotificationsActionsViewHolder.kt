package com.fsck.k9.ui.settings.notifications.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.fsck.k9.ui.settings.notifications.model.ItemsManager

sealed class NotificationsActionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(notificationAction: ItemsManager.Item)

    class Normal(itemView: View) : NotificationsActionsViewHolder(itemView) {
        override fun bind(notificationAction: ItemsManager.Item) {

        }
    }

    class Header(itemView: View) : NotificationsActionsViewHolder(itemView) {
        override fun bind(notificationAction: ItemsManager.Item) {

        }
    }
}