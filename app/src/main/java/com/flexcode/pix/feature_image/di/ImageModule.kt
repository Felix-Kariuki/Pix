package com.flexcode.pix.feature_image.di

import android.app.Application
import androidx.room.Room
import com.flexcode.pix.core.util.Constants
import com.flexcode.pix.feature_image.data.local.Database
import com.flexcode.pix.feature_image.data.remote.ImageApiService
import com.flexcode.pix.feature_image.data.repository.ImageRepositoryImpl
import com.flexcode.pix.feature_image.domain.repository.ImageRepository
import com.flexcode.pix.feature_image.domain.use_case.GetImages
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
object ImageModule {

    @Provides
    @Singleton
    fun provideGetImagesUseCase(repository: ImageRepository): GetImages {
        return GetImages(
            repository = repository
        )
    }


    @Provides
    @Singleton
    fun providesImageRepository(
        db: Database,
        apiService: ImageApiService
    ): ImageRepository {
        return ImageRepositoryImpl(
            apiService = apiService,
            dao = db.dao
        )
    }



    @Provides
    @Singleton
    fun providesDatabase(application: Application): Database {
        return Room.databaseBuilder(
            application,
            Database::class.java,
            "local_db"
        )
            .build()
    }

}