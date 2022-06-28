package com.flexcode.pix.feature_video.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideos(videos: List<VideoEntity>)


    @Query("DELETE FROM videoEntity WHERE pageURL IN(:videos)")
    suspend fun deleteVideos(videos: List<String>)

    @Query("SELECT * FROM VideoEntity WHERE tags OR pageURL OR pageURL LIKE '%' || :query || '%'")
    suspend fun getVideos(query: String?):List<VideoEntity>
}