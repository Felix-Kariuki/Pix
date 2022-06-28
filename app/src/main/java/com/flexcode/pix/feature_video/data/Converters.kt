package com.flexcode.pix.feature_video.data

import androidx.room.TypeConverter
import com.flexcode.pix.feature_video.domain.model.Videos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun toVideos(json: String): Videos {
        val type = object : TypeToken<Videos>(){}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJsonVideos(video: Videos): String {
        val type = object: TypeToken<Videos>(){}.type
        return Gson().toJson(video, type)
    }
}