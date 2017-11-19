package com.reminderapp.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.reminderapp.models.ReminderItemModel
import android.widget.TextView
import android.view.LayoutInflater
import com.example.anamaria.reminderapp.R


class ReminderAdapter(private val context: Context, private var items: List<ReminderItemModel>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertViewLocal = convertView
        if (convertViewLocal == null) {
            convertViewLocal = LayoutInflater.from(context).inflate(R.layout.item_reminder, parent, false)
        }

        val currentItem = getItem(position)
        val newItemTitle = convertViewLocal!!.findViewById<TextView>(R.id.item_title)
        newItemTitle.text = currentItem.title

        return convertViewLocal!!
    }

    override fun getItem(position: Int): ReminderItemModel = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = items.size

}