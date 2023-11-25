package com.example.nesthunt

import android.os.Parcel
import android.os.Parcelable

data class dataclass(var image: Int,var name: String, var address: String, var rate: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dataclass> {
        override fun createFromParcel(parcel: Parcel): dataclass {
            return dataclass(parcel)
        }

        override fun newArray(size: Int): Array<dataclass?> {
            return arrayOfNulls(size)
        }
    }
}
