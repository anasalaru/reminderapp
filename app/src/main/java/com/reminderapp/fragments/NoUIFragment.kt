package com.reminderapp.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log

class NoUIFragment: Fragment() {
    private val TAG = "REMINDERITEMSFRAGMENT"

    companion object {
        fun newInstance() = NoUIFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, "BACKGROUND WORKER -> onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "BACKGROUND WORKER -> onCreate")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "BACKGROUND WORKER -> onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "BACKGROUND WORKER -> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "BACKGROUND WORKER -> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "BACKGROUND WORKER -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "BACKGROUND WORKER -> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "BACKGROUND WORKER -> onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "BACKGROUND WORKER -> onDetach")
    }
}