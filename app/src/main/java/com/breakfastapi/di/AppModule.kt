package com.breakfastapi.di

import android.app.Application
import androidx.room.Room
import com.breakfastapi.database.RecipeDatabase
import com.breakfastapi.network.ApiService
import com.breakfastapi.repository.Repository
import com.breakfastapi.repository.Repository_Impl
import com.breakfastapi.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService, recipeDatabase: RecipeDatabase): Repository {
        return Repository_Impl(apiService, recipeDatabase)
    }

    @Singleton
    @Provides
    fun ProvideReceipeDatabase(application: Application): RecipeDatabase {
        return Room.databaseBuilder(application, RecipeDatabase::class.java, "recipe_db")
            .fallbackToDestructiveMigration().build()
    }

}