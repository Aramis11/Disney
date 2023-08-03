package com.edw.data.api

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.edw.data.db.CharacterDatabase
import com.edw.data.db.CharacterEntity
import com.edw.data.mappers.asDomainModel
import retrofit2.HttpException
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val characterDB: CharacterDatabase,
    private val characterApi: CharacterApi
) : RemoteMediator<Int, CharacterEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        val character = characterApi.getCharacter(
            page = 1,
            pageSize = state.config.pageSize
        )
        return MediatorResult.Success(endOfPaginationReached = character.isEmpty())
    }
}