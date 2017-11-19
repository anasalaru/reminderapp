package com.example.anamaria.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import com.reminderapp.ui.ReminderAdapter

class MainActivity : AppCompatActivity() {

    lateinit private var reminderAdapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reminderAdapter = ReminderAdapter(this, DataManager.provideData())
        reminder_listview.adapter = reminderAdapter
        reminder_listview.setOnItemClickListener { parent, view, position, id ->
            editReminder(view)
        }
    }

    private fun editReminder(item: View) {

    }
}
