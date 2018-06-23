package com.reminderapp.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*

import com.example.anamaria.reminderapp.R
import com.reminderapp.data.DataManager
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
        val clicklistener = object: ClickListener {
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

class RecyclerClickListener(private val context: Context, private val recyclerView: RecyclerView,
                            private val clickListener: ClickListener): RecyclerView.OnItemTouchListener {
    private val gestureDetector = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener() {
//        Notified when a tap occurs with the up MotionEvent that triggered it.
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return true
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        if(child != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick((recyclerView.getChildViewHolder(child) as ReminderViewHolder).data.id)
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }
}

interface ClickListener {
    fun onClick(id: Int)
}