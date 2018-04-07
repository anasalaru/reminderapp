package com.reminderapp.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast

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
        val clicklistener = object: ClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(activity.baseContext, "Item $position clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(view: View, position: Int) {
                Toast.makeText(activity, "Item $position long tap", Toast.LENGTH_SHORT).show()
            }

        }
        reminders_list.addOnItemTouchListener(RecyclerClickListener(activity, reminders_list, clicklistener))

    }

}

class RecyclerClickListener(private val context: Context, private val recyclerView: RecyclerView,
                            private val clickListener: ClickListener): RecyclerView.OnItemTouchListener {
    private val gestureDetector = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener() {
//        Notified when a tap occurs with the up MotionEvent that triggered it.
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            val child = recyclerView.findChildViewUnder(e.x, e.y)
            if(child != null) {
                clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child))
            }
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        if(child != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildAdapterPosition(child))
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }
}

interface ClickListener {
    fun onClick(view: View, position: Int)
    fun onLongClick(view: View, position: Int)
}