package com.edw.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characterentity")
    fun pagingSource(): PagingSource<Int,CharacterEntity>

    @Upsert
    suspend fun upsertAll(character: List<CharacterEntity>)

    @Query("DELETE FROM characterentity")
    suspend fun deleteAll()
}