package com.reminderapp.data

import com.reminderapp.models.ReminderItemModel

object DataManager {
    private var currentIndex = -1
    private val reminderItems = listOf(ReminderItemModel(nextIndex(), "pay bills", true),
            ReminderItemModel( nextIndex(), "go to doctor"),
            ReminderItemModel( nextIndex(), "feed the cat"),
            ReminderItemModel( nextIndex(), "meet Jane"),
            ReminderItemModel( nextIndex(), "walk the dog"),
            ReminderItemModel( nextIndex(), "respond to emails", true),
            ReminderItemModel( nextIndex(), "read emails"),
            ReminderItemModel( nextIndex(), "finish reading Pride and Prejudice"),
            ReminderItemModel( nextIndex(), "order food"),
            ReminderItemModel( nextIndex(), "do the laundry"),
            ReminderItemModel( nextIndex(), "go to the movies", true),
            ReminderItemModel( nextIndex(), "get present for mom's birthday"),
            ReminderItemModel( nextIndex(), "mom's birthday"),
            ReminderItemModel( nextIndex(), "swimming lesson"),
            ReminderItemModel( nextIndex(), "buy plates"),
            ReminderItemModel( nextIndex(), "look at furniture for new apartment"),
            ReminderItemModel( nextIndex(), "change internet contract"),
            ReminderItemModel( nextIndex(), "return clothes", true),
            ReminderItemModel( nextIndex(), "go shopping for groceries"),
            ReminderItemModel( nextIndex(), "prepare dinner for guests"),
            ReminderItemModel( nextIndex(), "take pictures for Instagram"),
            ReminderItemModel( nextIndex(), "prepare caption for Instagram post"),
            ReminderItemModel( nextIndex(), "learn to sing"),
            ReminderItemModel( nextIndex(), "change the sheets"),
            ReminderItemModel( nextIndex(), "buy tickets for concert")
    )

    fun provideData() = reminderItems

    fun updateItem(reminderItem: ReminderItemModel) {
        val reminderIndex = reminderItems.indexOfFirst { it.id == reminderItem.id }
        reminderItems[reminderIndex].title = reminderItem.title
    }

    private fun nextIndex(): Int {
        currentIndex ++
        return currentIndex
    }
}