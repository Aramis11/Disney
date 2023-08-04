package com.edw.data.mappers

import com.edw.data.api.CharacterInfoDTO
import com.edw.data.db.CharacterEntity
import com.edw.data.domain.CharacterInfo


fun CharacterInfoDTO.asDomainModel() = CharacterEntity(
    id = id,
    sourceUrl = sourceUrl,
    name = name,
    imageUrl = imageUrl ?: "",
    created = created,
    updated = updated,
    url = url
)

fun CharacterEntity.asCharacter() = CharacterInfo(
    id = id,
    sourceUrl = sourceUrl,
    name = name,
    imageUrl = imageUrl,
    created = created,
    updated = updated,
    url = url
)
