package com.reminderapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anamaria.reminderapp.R

class AdvertisingFragment: Fragment() {

    companion object {
        fun newInstance() = AdvertisingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_advertising, container, false)
    }
}