package com.flexcode.pix.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videos(

    var large: Large? = Large(),
    var medium: Medium? = Medium(),
    var small: Small? = Small(),
    var tiny: Tiny? = Tiny()

) : Parcelable
