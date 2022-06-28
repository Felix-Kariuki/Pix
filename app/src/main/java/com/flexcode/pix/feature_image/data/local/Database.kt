package com.flexcode.pix.feature_image.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flexcode.pix.feature_image.data.local.entity.ImageEntity

@Database(entities = [ImageEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val dao: Dao
}