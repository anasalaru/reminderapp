package com.reminderapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.anamaria.reminderapp.R
import com.reminderapp.activities.ReminderActivity
import com.reminderapp.data.DataManager
import com.reminderapp.ui.ReminderAdapter
import kotlinx.android.synthetic.main.fragment_reminder_items.reminder_listview

class ReminderItemsFragment : Fragment() {
    lateinit private var reminderAdapter: ReminderAdapter

    companion object {
        fun newInstance(): Fragment = ReminderItemsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reminder_items, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reminderAdapter = ReminderAdapter(activity, DataManager.provideData())
        reminder_listview.adapter = reminderAdapter
        reminder_listview.setOnItemClickListener { _, _, position, _ ->
            (activity as ReminderActivity).itemClicked(reminderAdapter.getItem(position))
        }
    }

}