package com.reminderapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_reminder_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_send_mail) {
            sendEmail()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sendEmail() {
        val content = "Hey! Don't forget to ${edit_reminder_title.text}. Thanks a lot!"
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc2822"
        intent.putExtra(Intent.EXTRA_SUBJECT, "ReminderAPP")
        intent.putExtra(Intent.EXTRA_TEXT, content)
        startActivity(intent)
    }
}
