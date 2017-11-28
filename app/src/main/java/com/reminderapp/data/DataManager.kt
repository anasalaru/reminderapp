package com.reminderapp.data

import com.reminderapp.models.ReminderItemModel

object DataManager {
    private val reminderItems = listOf(ReminderItemModel(1, "pay bills"),
            ReminderItemModel(2, "go to doctor"),
            ReminderItemModel(3, "feed the cat"),
            ReminderItemModel(4, "meet Jane")
    )

    fun provideData() = reminderItems

    fun updateItem(reminderItem: ReminderItemModel) {
        val reminderIndex = reminderItems.indexOfFirst { it.id == reminderItem.id }
        reminderItems[reminderIndex].title = reminderItem.title
    }
}