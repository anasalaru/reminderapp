package com.reminderapp.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

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