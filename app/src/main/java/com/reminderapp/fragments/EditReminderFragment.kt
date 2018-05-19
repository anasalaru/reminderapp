package com.reminderapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import com.reminderapp.models.ReminderItemModel
import kotlinx.android.synthetic.main.fragment_edit_reminder.edit_reminder_title

class EditReminderFragment: Fragment() {

    private lateinit var reminderItem: ReminderItemModel

    companion object {
        fun newInstance(itemID: Int): Fragment {
            val newFragment = EditReminderFragment()
            val args = Bundle()
            args.putInt("reminderItem", itemID)
            newFragment.arguments = args
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_edit_reminder, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val itemID = arguments.getInt("reminderItem")
        reminderItem = DataManager.provideData().firstOrNull { it.id == itemID } ?: ReminderItemModel(100, "errrr")
        edit_reminder_title.setText(reminderItem.title)
    }

    override fun onPause() {
        super.onPause()
        reminderItem.title = edit_reminder_title.text.toString()
        DataManager.updateItem(reminderItem)
    }
}