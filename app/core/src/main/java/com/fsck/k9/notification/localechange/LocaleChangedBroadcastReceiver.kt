package com.fsck.k9.notification.localechange

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LocaleChangedBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val service = Intent(context,LocaleChangedService::class.java)
        context?.startService(service)
    }
}
