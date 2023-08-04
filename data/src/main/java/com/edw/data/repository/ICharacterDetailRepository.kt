package com.edw.data.repository

import com.edw.data.domain.CharacterDetail

interface ICharacterDetailRepository { suspend fun charactersDetail(id: Int): CharacterDetail }