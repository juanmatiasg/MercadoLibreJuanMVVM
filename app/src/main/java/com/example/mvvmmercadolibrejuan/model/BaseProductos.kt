package com.example.mvvmmercadolibrejuan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseProductos(
    @SerializedName("results")
    var items:List<Items>
):Parcelable