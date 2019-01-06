package com.fsck.k9.notification.localechange

import android.app.IntentService
import android.content.Intent
import com.fsck.k9.notification.NotificationChannelManager
import org.koin.android.ext.android.inject

class LocaleChangedService : IntentService("LocaleChangedService") {
    private val notificationChannelManager: NotificationChannelManager by inject()

    override fun onHandleIntent(intent: Intent?) {
        notificationChannelManager.updateChannels()
    }
}
