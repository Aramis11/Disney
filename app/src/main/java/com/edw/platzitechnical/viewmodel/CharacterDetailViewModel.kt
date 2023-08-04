package com.edw.platzitechnical.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.data.domain.CharacterDetail
import com.edw.data.repository.CharacterDetailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(var characterDetailRepository: CharacterDetailRepositoryImpl) :
    ViewModel() {

    private var _characterDetail = MutableLiveData<CharacterDetail>()
    val characterDetail: LiveData<CharacterDetail>
        get() = _characterDetail

    val state by mutableStateOf(State())

    fun getDetailCharacter(id: Int) {
        viewModelScope.launch {
            runCatching {
                characterDetailRepository.charactersDetail(id)
            }.onSuccess { character ->
                _characterDetail.value = character
            }.onFailure {
                Log.e("test", it.message.toString())
            }
        }
    }
}

data class State(
    var Loading: Boolean = true
)