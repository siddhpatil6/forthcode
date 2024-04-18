package com.forthcode.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForthCodePhotosItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
):Parcelable