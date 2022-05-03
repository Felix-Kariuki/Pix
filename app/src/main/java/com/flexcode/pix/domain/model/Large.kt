package com.flexcode.pix.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Large (

    var url    : String? = null,
   var width  : Int?    = null,
     var height : Int?    = null,
     var size   : Int?    = null

) :  Parcelable
