package com.reminderapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import kotlinx.android.synthetic.main.fragment_reminder_items.*

class ReminderItemsFragment : Fragment() {
//    lateinit private var reminderAdapter: ReminderAdapter

    companion object {
        fun newInstance(): Fragment = ReminderItemsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reminder_items, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reminders_list.layoutManager = LinearLayoutManager(activity.baseContext)
        reminders_list.adapter = RemindersListAdapter(DataManager.provideData())


    }

}