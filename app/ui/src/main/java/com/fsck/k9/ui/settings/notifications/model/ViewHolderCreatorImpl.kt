package com.fsck.k9.ui.settings.notifications.model

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fsck.k9.ui.R
import com.fsck.k9.ui.settings.notifications.view.NotificationsActionsAdapter
import com.fsck.k9.ui.settings.notifications.view.NotificationsActionsViewHolder

class ViewHolderCreatorImpl : NotificationActionsViewHolderCreator {

    override fun createHolder(parent: ViewGroup, viewType: Int): NotificationsActionsViewHolder =
        when (viewType) {
            NotificationsActionsAdapter.ViewType.HEADER_1 -> getHeader(parent)
            NotificationsActionsAdapter.ViewType.HEADER_2 -> getHeader(parent)
            else -> getNormalHolder(parent)
        }

    private fun getNormalHolder(parent: ViewGroup) =
        NotificationsActionsViewHolder.Normal(getView(R.layout.notifications_actions_item, parent))

    private fun getHeader(parent: ViewGroup) =
        NotificationsActionsViewHolder.Header(getView(R.layout.notifications_actions_item, parent))
    
    private fun getLayoutInflater(parent: ViewGroup) =
        LayoutInflater.from(parent.getContext())

    private fun getView(@LayoutRes res: Int, parent: ViewGroup) =
        getLayoutInflater(parent).inflate(res, parent, false)
}