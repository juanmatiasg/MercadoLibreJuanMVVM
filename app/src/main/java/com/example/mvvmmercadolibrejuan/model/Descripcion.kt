package com.example.mvvmmercadolibrejuan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Descripcion (
    @SerializedName("id") var id: String,
    @SerializedName("plain_text") var plain_text: String
):Parcelable
