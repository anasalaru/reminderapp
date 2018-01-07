package com.reminderapp.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
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
        private val TAG = "REMINDERITEMSFRAGMENT"
        fun newInstance(): Fragment = ReminderItemsFragment()
    }

    private var counter = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Fragment -> onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment -> onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "Fragment -> onCreateView")

        return inflater.inflate(R.layout.fragment_reminder_items, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reminderAdapter = ReminderAdapter(activity, DataManager.provideData())
        reminder_listview.adapter = reminderAdapter
        reminder_listview.setOnItemClickListener { _, _, position, _ ->
            (activity as ReminderActivity).itemClicked(reminderAdapter.getItem(position))
        }
        Log.d(TAG, "Fragment -> onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Fragment -> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment -> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Fragment -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Fragment -> onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment -> onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "Fragment -> onDetach")
    }

}