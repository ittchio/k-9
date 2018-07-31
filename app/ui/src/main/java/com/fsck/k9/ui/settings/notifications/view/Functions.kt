package com.fsck.k9.ui.settings.notifications.view

import com.fsck.k9.ui.settings.notifications.model.NotificationAction

fun crateItems(): List<NotificationAction> =
    "ABCDEFGHILMONPQRSTUVZ".toList().map {
        NotificationAction(it.toString(), it.toString().toLowerCase())
    }
