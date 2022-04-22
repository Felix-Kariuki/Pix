package com.flexcode.pix.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val dao:Dao
}