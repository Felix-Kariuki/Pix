package com.flexcode.pix.di

import android.app.Application
import androidx.room.Room
import com.flexcode.pix.data.local.Database
import com.flexcode.pix.data.repository.ImageRepositoryImpl
import com.flexcode.pix.domain.repository.ImageRepository
import com.flexcode.pix.domain.usecase.GetImages
import com.flexcode.pix.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.flexcode.pix.data.remote.ApiService as ApiService

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetImagesUseCase(repository: ImageRepository): GetImages {
        return GetImages(
            repository = repository
        )
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(15,TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesImageRepository(
        db : Database,
        apiService: ApiService
    ): ImageRepository {
        return ImageRepositoryImpl(
            apiService = apiService,
            dao = db.dao
        )
    }


    @Provides
    @Singleton
    fun providesDatabase(application: Application) : Database{
        return Room.databaseBuilder(
            application,
            Database::class.java,
            "local_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesApiService(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }


}