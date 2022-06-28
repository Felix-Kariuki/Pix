package com.flexcode.pix.feature_video.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.flexcode.pix.feature_video.data.Converters

@Database(entities = [VideoEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract  class VideoDatabase : RoomDatabase() {

    abstract val videoDao: VideoDao


}