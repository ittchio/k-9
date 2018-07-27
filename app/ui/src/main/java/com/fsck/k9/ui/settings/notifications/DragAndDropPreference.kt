package com.fsck.k9.ui.settings.notifications

import android.content.Context
import android.support.v7.preference.Preference
import android.util.AttributeSet
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat

class DragAndDropPreference constructor(
    context: Context,
    attrs: AttributeSet
) : Preference(context, attrs) {

    init {
        PreferenceFragmentCompat.registerPreferenceFragment(
            DragAndDropPreference::class.java,
            DragAndDropPreferenceFragment::class.java
        )
    }

    override fun onClick() {
        preferenceManager.showDialog(this)
    }
}