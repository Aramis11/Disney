package com.edw.platzitechnical.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.data.domain.CharacterDetail
import com.edw.data.repository.CharacterDetailRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    var characterDetailRepository: CharacterDetailRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private var _characterDetail = MutableLiveData<CharacterDetail>()
    val characterDetail: LiveData<CharacterDetail>
        get() = _characterDetail

    fun getDetailCharacter(id: Int) {

        viewModelScope.launch(defaultDispatcher) {
            runCatching {
                characterDetailRepository.charactersDetail(id)
            }.onSuccess { character ->
                _characterDetail.postValue(character)
            }.onFailure {
                Log.e("onFailure", it.message.toString())
            }
        }
    }
}