package com.edw.data.api.character

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.edw.data.api.CharacterApi
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
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize)  + 1 / 10
                    }
                }
            }

            val characterFromApi = characterApi.getCharacter(
                page = loadKey,
                pageSize = state.config.pageSize
            )

            characterDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    characterDB.dao.deleteAll()
                }
                characterDB.dao.upsertAll(characterFromApi.character.map { it.asDomainModel() })
            }

            MediatorResult.Success(
                endOfPaginationReached = characterFromApi.character.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}