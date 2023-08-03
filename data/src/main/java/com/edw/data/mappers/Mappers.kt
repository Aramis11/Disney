package com.edw.data.mappers

import com.edw.data.api.CharacterDTO
import com.edw.data.db.CharacterEntity
import com.edw.data.domain.Character
import com.edw.data.domain.CharacterInfo


fun CharacterDTO.asDomainModel() = CharacterEntity(
    _id = _id,
    sourceUrl = sourceUrl,
    name = name,
    imageUrl = imageUrl,
    createdAt = createdAt,
    updatedAt = updatedAt,
    url = url
)

fun CharacterEntity.asCharacter() = CharacterInfo(
    _id = _id,
    sourceUrl = sourceUrl,
    name = name,
    imageUrl = imageUrl,
    createdAt = createdAt,
    updatedAt = updatedAt,
    url = url
)
