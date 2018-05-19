package com.reminderapp.models

import android.os.Parcel
import android.os.Parcelable

data class ReminderItemModel(var id: Int, var title: String, var important: Boolean = false): Parcelable, BaseViewModel {
    override var type: Int = if (important) ModelType.REMINDER_IMPORTANT.ordinal else ModelType.REMINDER.ordinal

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
    }

    override fun equals(other: Any?): Boolean {
        other as ReminderItemModel
        return id == other.id &&
                title == other.title &&
                type == other.type &&
                important == other.important
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + important.hashCode()
        result = 31 * result + type
        return result
    }

    companion object CREATOR : Parcelable.Creator<ReminderItemModel> {
        override fun createFromParcel(parcel: Parcel): ReminderItemModel {
            return ReminderItemModel(parcel)
        }

        override fun newArray(size: Int): Array<ReminderItemModel?> {
            return arrayOfNulls(size)
        }
    }


}