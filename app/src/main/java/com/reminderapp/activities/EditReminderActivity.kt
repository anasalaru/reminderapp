package com.reminderapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import com.reminderapp.models.ReminderItemModel
import kotlinx.android.synthetic.main.activity_edit_reminder.edit_reminder_title

class EditReminderActivity : AppCompatActivity() {

    lateinit private var reminderItem: ReminderItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_reminder)

        reminderItem = intent.getParcelableExtra<ReminderItemModel>("reminder")
        edit_reminder_title.setText(reminderItem.title, TextView.BufferType.EDITABLE)
    }

    override fun onPause() {
        super.onPause()

        reminderItem.title = edit_reminder_title.text.toString()
        Log.d("reminderapp", reminderItem.title)
        DataManager.updateItem(reminderItem)
    }
}
