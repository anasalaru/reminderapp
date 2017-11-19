package com.example.anamaria.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import com.reminderapp.ui.ReminderItemAdapter

class MainActivity : AppCompatActivity() {

    lateinit private var reminderAdapter: ReminderItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reminder_recyclerview.layoutManager = LinearLayoutManager(this)
        reminderAdapter= ReminderItemAdapter()
        reminder_recyclerview.adapter = reminderAdapter
        reminderAdapter.updateItems(DataManager.provideData())
    }
}
