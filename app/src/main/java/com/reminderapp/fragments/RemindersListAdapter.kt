package com.reminderapp.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anamaria.reminderapp.R
import com.reminderapp.models.ReminderItemModel
import kotlinx.android.synthetic.main.item_reminder.view.*

class RemindersListAdapter(val dataSet: List<ReminderItemModel>): RecyclerView.Adapter<ReminderViewHolderImpl>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolderImpl {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolderImpl(item)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ReminderViewHolderImpl?, position: Int) {
        holder?.bind(dataSet[position])
    }

}

class ReminderViewHolderImpl(itemView: View): RecyclerView.ViewHolder(itemView), ReminderViewHolder {
    override lateinit var data: ReminderItemModel
    fun bind(item: ReminderItemModel) {
        data = item
        with(itemView) {
            item_deadline.text = "In ${item.id} days"
            item_title.text = item.title
        }
    }
}

interface ReminderViewHolder {
    val data: ReminderItemModel
}
