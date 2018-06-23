package com.reminderapp.recyclerview

import com.reminderapp.models.ReminderItemModel

interface ReminderViewHolder {
    val data: ReminderItemModel
    fun bind(item: ReminderItemModel)
}