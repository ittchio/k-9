package com.fsck.k9.ui.settings.notifications.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.AttributeSet
import com.fsck.k9.ui.settings.notifications.model.ItemsManagerImpl
import com.fsck.k9.ui.settings.notifications.model.ItemsMover
import com.fsck.k9.ui.settings.notifications.model.ViewHolderCreatorImpl

class DragAndDropRecyclerView(context: Context, attributeSet: AttributeSet) :
    RecyclerView(context, attributeSet) {

    init {
        val itemsManager = ItemsManagerImpl(ItemsMover())
        val dragAndDropAdapter =
            NotificationsActionsAdapter(itemsManager, ViewHolderCreatorImpl())//TODO inject here
        adapter = dragAndDropAdapter
        layoutManager = LinearLayoutManager(context)
        ItemTouchHelper(dragAndDropAdapter.itemTouchHelperCallback)
            .attachToRecyclerView(this)
    }
}