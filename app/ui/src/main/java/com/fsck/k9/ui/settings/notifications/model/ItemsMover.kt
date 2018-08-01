package com.fsck.k9.ui.settings.notifications.model

class ItemsMover {
    fun moveIsSucessful(from: ItemsManager.Item, to: ItemsManager.Item): Boolean {
        return when {
            from is ItemsManager.Item.HeaderTwo -> false
            from is ItemsManager.Item.HeaderOne -> false
            to is ItemsManager.Item.HeaderOne -> false
            to is ItemsManager.Item.HeaderOne -> false
            else -> true
        }
    }
}