package com.reminderapp.activities

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.anamaria.reminderapp.R
import com.reminderapp.fragments.EditReminderFragment
import com.reminderapp.fragments.ReminderItemsFragment
import com.reminderapp.models.ReminderItemModel

class ReminderActivity : AppCompatActivity() {

    private val TAG = "REMINDERITEMSFRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(ReminderItemsFragment.newInstance(), false)
        Log.d(TAG, "Activity -> onCreate")
    }

    private fun addFragment(fragment: Fragment, replace: Boolean) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if(replace)
            fragmentTransaction.replace(R.id.main_container, fragment)
        else
            fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity -> onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity -> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity -> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity -> onDestroy")
    }

    fun itemClicked(item: ReminderItemModel) {
        Log.d("test", "item clicked")
        addFragment(EditReminderFragment.newInstance(item), true)
    }
}
