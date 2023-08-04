package com.edw.platzitechnical.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.data.db.CharacterEntity
import javax.inject.Inject
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.edw.data.mappers.asCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map

@HiltViewModel
class CharacterViewModel @Inject constructor(
    pager: Pager<Int, CharacterEntity>
) : ViewModel() {

    val characterPaging = pager
        .flow
        .map { data ->
            data.map { it.asCharacter() }
        }.cachedIn(viewModelScope)

}