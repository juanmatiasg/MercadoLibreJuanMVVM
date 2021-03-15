package com.example.mvvmmercadolibrejuan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items (
    @SerializedName("id")
    var id:String,
    @SerializedName("title")
    var title:String,
    @SerializedName("price")
    var price:Double,
    @SerializedName("thumbnail")
    var thumbnail:String,
    @SerializedName("secure_thumbnail")
    var secure_thumbnail:String,
    @SerializedName("permalink")
    var permalink:String,
    @SerializedName("descriptions")
    var descriptions:MutableList<Descripcion>,
    @SerializedName("pictures")
    var pictures:MutableList<Pictures>
):Parcelable


