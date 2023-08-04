package com.edw.data.repository

import com.edw.data.api.CharacterApi
import com.edw.data.domain.CharacterDetail
import com.edw.data.mappers.asDomainModel
import javax.inject.Inject

class CharacterDetailRepositoryImpl @Inject constructor(
    private val characterDetail: CharacterApi
) : CharacterDetailRepository {
    override suspend fun charactersDetail(id: Int): CharacterDetail {
        return characterDetail.getCharacter(id).asDomainModel()
    }
}