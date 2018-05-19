package com.reminderapp.fragments

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anamaria.reminderapp.R
import com.reminderapp.models.ModelType
import com.reminderapp.models.ReminderItemModel
import kotlinx.android.synthetic.main.item_reminder.view.*

class RemindersListAdapterImpl(private val dataSet: List<ReminderItemModel>): RecyclerView.Adapter<BaseViewHolder>(), RemindersListAdapter {
    private lateinit var reminderDiff: ReminderListDiffCallback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            ModelType.REMINDER.ordinal -> viewHolder(parent)
            ModelType.REMINDER_IMPORTANT.ordinal -> viewHolderImportant(parent)
            else -> throw IllegalArgumentException("nope.")
        }
    }

    private fun viewHolder(parent: ViewGroup): BaseViewHolder{
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolderImpl(item)
    }

    private fun viewHolderImportant(parent: ViewGroup): ReminderViewHolderImportantImpl {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder_important, parent, false)
        return ReminderViewHolderImportantImpl(item)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        return when(getItemViewType(position)) {
            ModelType.REMINDER.ordinal -> (holder as ReminderViewHolderImpl).bind(dataSet[position])
            ModelType.REMINDER_IMPORTANT.ordinal -> (holder as ReminderViewHolderImportantImpl).bind(dataSet[position])
            else -> throw IllegalArgumentException("nope.")
        }
    }

    override fun updateList(newList: List<ReminderItemModel>) {
        reminderDiff = ReminderListDiffCallback(dataSet, newList)
        val result = DiffUtil.calculateDiff(reminderDiff)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int =
        dataSet[position].type
}

class ReminderViewHolderImpl(itemView: View): BaseViewHolder(itemView) {
    override lateinit var data: ReminderItemModel
    override fun bind(item: ReminderItemModel) {
        data = item
        with(itemView) {
            item_deadline.text = "In ${item.id} days"
            item_title.text = item.title
        }
    }
}

class ReminderViewHolderImportantImpl(itemView: View): BaseViewHolder(itemView) {
    override lateinit var data: ReminderItemModel
    override fun bind(item: ReminderItemModel) {
        data = item
        with(itemView) {
            item_deadline.text = "In ${item.id} days"
            item_title.text = item.title
        }
    }
}

interface ReminderViewHolder {
    val data: ReminderItemModel
    fun bind(item: ReminderItemModel)
}

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), ReminderViewHolder

interface RemindersListAdapter {
    fun updateList(newList: List<ReminderItemModel>)
}

class ReminderListDiffCallback(private val oldList: List<ReminderItemModel>,
                               private  val newList: List<ReminderItemModel>): DiffUtil.Callback() {

    //decides if two objects represent the same object
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    //decides whether two items have same data or not.
    //This method is called by DiffUtil only if areItemsTheSame() returns true.
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
