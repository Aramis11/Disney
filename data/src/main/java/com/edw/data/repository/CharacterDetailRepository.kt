package com.edw.data.repository

import com.edw.data.domain.CharacterDetail

interface CharacterDetailRepository { suspend fun charactersDetail(id: Int): CharacterDetail }