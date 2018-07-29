package com.fsck.k9.ui.settings.notifications.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.AttributeSet

class DragAndDropRecyclerView(context: Context, attributeSet: AttributeSet) :
    RecyclerView(context, attributeSet) {

    init {
        adapter = DragAndDropAdapter()
        layoutManager = LinearLayoutManager(context)
        ItemTouchHelper(ItemTouchHelperCallback(adapter)).attachToRecyclerView(this)
    }
}