package com.flexcode.pix.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tiny(

    var url: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var size: Int? = null

) : Parcelable