package com.flexcode.pix.feature_video.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Small(

    var url: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var size: Int? = null

) : Parcelable
