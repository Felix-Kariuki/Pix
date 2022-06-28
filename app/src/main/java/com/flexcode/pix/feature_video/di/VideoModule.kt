package com.flexcode.pix.feature_video.di

import android.app.Application
import androidx.room.Room
import com.flexcode.pix.core.util.Constants
import com.flexcode.pix.feature_video.data.local.VideoDatabase
import com.flexcode.pix.feature_video.data.remote.VideoApiService
import com.flexcode.pix.feature_video.data.repository.VideoRepositoryImpl
import com.flexcode.pix.feature_video.domain.repository.VideoRepository
import com.flexcode.pix.feature_video.domain.usecase.GetVideos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VideoModule {

    @Provides
    @Singleton
    fun providesVideosUseCase(repository: VideoRepository): GetVideos {
        return GetVideos(
            repository = repository
        )
    }

    @Provides
    @Singleton
    fun providesVideoDatabase(application: Application): VideoDatabase {
        return Room.databaseBuilder(
            application,
            VideoDatabase::class.java,
            "local_video_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideVideoRepository(
        db: VideoDatabase,
        apiService: VideoApiService
    ): VideoRepository {
        return VideoRepositoryImpl(
            apiService = apiService,
            dao = db.videoDao
        )
    }

    @Provides
    @Singleton
    fun providesApiService(): VideoApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        return retrofit.create(VideoApiService::class.java)
    }



}