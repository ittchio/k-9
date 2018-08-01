package com.fsck.k9.ui.settings.notifications.model

import android.view.ViewGroup
import com.fsck.k9.ui.settings.notifications.view.NotificationsActionsViewHolder

interface NotificationActionsViewHolderCreator {
    fun createHolder(parent: ViewGroup, viewType: Int): NotificationsActionsViewHolder
}