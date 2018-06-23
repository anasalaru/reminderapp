package com.reminderapp.recyclerview

import com.reminderapp.models.ReminderItemModel

interface RemindersListAdapter {
    fun updateList(newList: List<ReminderItemModel>)
}