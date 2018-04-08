package com.reminderapp.models

import android.os.Parcel
import android.os.Parcelable

data class ReminderItemModel(var id: Int, var title: String): Parcelable {
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
                title == other.title
    }

    override fun describeContents(): Int {
        return 0
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