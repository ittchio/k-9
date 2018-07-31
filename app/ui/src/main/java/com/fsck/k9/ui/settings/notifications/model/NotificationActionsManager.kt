package com.fsck.k9.ui.settings.notifications.model

import com.fsck.k9.ui.settings.notifications.view.crateItems

class NotificationActionsManager {
    private var items: List<NotificationAction> = crateItems()

    val count: Int
        get() = items.size

    operator fun get(position: Int): NotificationAction = items[position]
}