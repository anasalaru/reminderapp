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

    lateinit private var reminderItem: ReminderItemModel

    companion object {
        fun newInstance(item: ReminderItemModel): Fragment {
            val newFragment = EditReminderFragment()
            val args = Bundle()
            args.putParcelable("reminderItem", item)
            newFragment.arguments = args
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_edit_reminder, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reminderItem = arguments.getParcelable("reminderItem")
        edit_reminder_title.setText(reminderItem.title)
    }

    override fun onPause() {
        super.onPause()
        reminderItem.title = edit_reminder_title.text.toString()
        DataManager.updateItem(reminderItem)
    }
}