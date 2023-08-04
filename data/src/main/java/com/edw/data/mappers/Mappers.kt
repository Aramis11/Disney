package com.edw.data.mappers

import com.edw.data.api.character.CharacterInfoDTO
import com.edw.data.api.characterDetail.CharacterDetailDTO
import com.edw.data.api.characterDetail.CharacterDetailInfoDTO
import com.edw.data.db.CharacterEntity
import com.edw.data.domain.CharacterDetail
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

fun CharacterDetailDTO.asDomainModel() = CharacterDetail(
    id = data.id,
    name = data.name,
    films = data.films,
    tvShows = data.tvShows,
    videoGames = data.videoGames,
    enemies = data.enemies,
    allies = data.allies,
    imageUrl = data.imageUrl
)
