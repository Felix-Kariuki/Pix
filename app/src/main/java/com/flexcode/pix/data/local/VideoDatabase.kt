package com.flexcode.pix.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [VideoEntity::class], version = 1)
abstract  class VideoDatabase : RoomDatabase() {
    abstract val videoDao: VideoDao
}