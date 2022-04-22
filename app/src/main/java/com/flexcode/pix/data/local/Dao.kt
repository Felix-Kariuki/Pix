package com.flexcode.pix.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ImageEntity>)

    @Query("DELETE FROM imageEntity WHERE previewURL IN(:images)")
    suspend fun deleteImages(images: List<String>)

    @Query("SELECT * FROM ImageEntity WHERE tags OR previewURL OR pageURL LIKE '%' || :query || '%'")
    suspend fun getImages(query: String?):List<ImageEntity>

}