package com.example.paw_store

import android.os.Parcel
import android.os.Parcelable

data class Datalist(val nam:String,val pass:String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nam)
        parcel.writeString(pass)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Datalist> {
        override fun createFromParcel(parcel: Parcel): Datalist {
            return Datalist(parcel)
        }

        override fun newArray(size: Int): Array<Datalist?> {
            return arrayOfNulls(size)
        }
    }

}
