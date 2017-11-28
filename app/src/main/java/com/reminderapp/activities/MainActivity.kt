package com.example.anamaria.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.anamaria.reminderapp.R
import com.reminderapp.activities.EditReminderActivity
import com.reminderapp.data.DataManager
import com.reminderapp.models.ReminderItemModel
import com.reminderapp.ui.ReminderAdapter

class MainActivity : AppCompatActivity() {

    lateinit private var reminderAdapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reminderAdapter = ReminderAdapter(this, DataManager.provideData())
        reminder_listview.adapter = reminderAdapter
        reminder_listview.setOnItemClickListener { parent, view, position, id ->
            editReminder(parent.adapter.getItem(position))
        }
    }

    override fun onResume() {
        super.onResume()

       reminderAdapter.notifyDataSetChanged()
    }

    private fun editReminder(item: Any) {
        val intent = Intent(this, EditReminderActivity::class.java)
        intent.putExtra("reminder", (item as ReminderItemModel))
        startActivity(intent)
    }
}
