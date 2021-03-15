package com.example.mvvmmercadolibrejuan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pictures(
    @SerializedName("id") var id: String,
    @SerializedName("url") var url: String,
    @SerializedName("secure_url") var secure_url: String
):Parcelable
