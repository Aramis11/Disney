package com.edw.platzitechnical.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.edw.data.api.CharacterApi
import com.edw.data.api.character.CharacterRemoteMediator
import com.edw.data.db.CharacterDatabase
import com.edw.data.db.CharacterEntity
import com.edw.data.repository.CharacterDetailRepositoryImpl
import com.edw.platzitechnical.BuildConfig
import com.edw.platzitechnical.viewmodel.CharacterDetailViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            "characters.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideApi(): CharacterApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideBeerPager(
        beerDb: CharacterDatabase,
        beerApi: CharacterApi
    ): Pager<Int, CharacterEntity> {
        return Pager(
            config = PagingConfig(pageSize = 50),
            remoteMediator = CharacterRemoteMediator(
                characterDB = beerDb,
                characterApi = beerApi
            ),
            pagingSourceFactory = {
                beerDb.dao.pagingSource()
            }
        )
    }

    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}