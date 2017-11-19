package ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.anamaria.reminderapp.R
import models.ReminderItemModel

class ReminderItemAdapter: RecyclerView.Adapter<ReminderItemAdapter.ReminderItemViewHolder>() {
    private var reminderItems = emptyList<ReminderItemModel>()

    override fun onBindViewHolder(holder: ReminderItemViewHolder, position: Int) {
        holder.setItem(reminderItems[position])
    }

    override fun getItemCount() = reminderItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder,
                parent, false)

        return ReminderItemViewHolder(itemView)
    }

    fun updateItems(itemList: List<ReminderItemModel>) {
        this.reminderItems = itemList
        notifyDataSetChanged()
    }

    class ReminderItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var itemReminderTitle = itemView.findViewById<TextView>(R.id.item_title)

        fun setItem(item: ReminderItemModel) {
            itemReminderTitle.text = item.title
        }
    }
}