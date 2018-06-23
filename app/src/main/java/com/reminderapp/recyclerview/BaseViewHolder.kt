package com.reminderapp.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), ReminderViewHolder
