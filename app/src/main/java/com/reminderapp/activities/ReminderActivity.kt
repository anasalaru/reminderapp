package com.reminderapp.activities

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.anamaria.reminderapp.R
import com.reminderapp.fragments.ReminderItemsFragment

class ReminderActivity : AppCompatActivity() {

    private val TAG = "REMINDERITEMSFRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(ReminderItemsFragment.newInstance(), false)
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
}
