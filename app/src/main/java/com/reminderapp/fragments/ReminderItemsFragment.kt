package com.reminderapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
import com.reminderapp.recyclerview.ClickListener
import com.reminderapp.recyclerview.RecyclerClickListener
import com.reminderapp.recyclerview.RemindersListAdapter
import com.reminderapp.recyclerview.RemindersListAdapterImpl
import kotlinx.android.synthetic.main.fragment_reminder_items.*

class ReminderItemsFragment : Fragment() {
    companion object {
        fun newInstance(): Fragment = ReminderItemsFragment()
    }

    private fun updateList() {
        (reminders_list.adapter as RemindersListAdapter).updateList(DataManager.provideData())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reminder_items, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reminders_list.layoutManager = LinearLayoutManager(activity.baseContext)
        reminders_list.adapter = RemindersListAdapterImpl(DataManager.provideData())
        val clicklistener = object : ClickListener {
            override fun onClick(id: Int) {
                editReminder(id)
            }
        }
        reminders_list.addOnItemTouchListener(RecyclerClickListener(activity, reminders_list, clicklistener))
    }

    private fun editReminder(itemID: Int) {
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, EditReminderFragment.newInstance(itemID))
                .addToBackStack(null)
                .commit()
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }
}

