package com.reminderapp.models

interface BaseViewModel {
    var type: Int
}

enum class ModelType {
    REMINDER, REMINDER_IMPORTANT
}