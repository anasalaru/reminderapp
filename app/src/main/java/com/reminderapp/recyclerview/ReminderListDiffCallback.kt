package com.reminderapp.recyclerview

import android.support.v7.util.DiffUtil
import com.reminderapp.models.ReminderItemModel

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
