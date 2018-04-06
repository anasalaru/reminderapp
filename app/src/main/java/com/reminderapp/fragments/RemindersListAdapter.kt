package com.reminderapp.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anamaria.reminderapp.R
import com.reminderapp.models.ReminderItemModel
import kotlinx.android.synthetic.main.item_reminder.view.*

class RemindersListAdapter(private val dataSet: List<ReminderItemModel>): RecyclerView.Adapter<ReminderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolder(item)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ReminderViewHolder?, position: Int) {
        holder?.bind(dataSet[position])
    }

}

class ReminderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(item: ReminderItemModel) {
        with(itemView) {
            item_deadline.text = "In ${item.id} days"
            item_title.text = item.title
        }
    }
}
