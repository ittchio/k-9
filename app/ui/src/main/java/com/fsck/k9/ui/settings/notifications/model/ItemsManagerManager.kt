package com.fsck.k9.ui.settings.notifications.model

interface ItemsManagerManager {
    val count: Int

    operator fun get(position: Int): NotificationAction
}