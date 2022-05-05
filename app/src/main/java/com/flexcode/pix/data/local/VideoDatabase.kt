package com.flexcode.pix.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.flexcode.pix.data.Converters

@Database(entities = [VideoEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract  class VideoDatabase : RoomDatabase() {

    abstract val videoDao: VideoDao


}