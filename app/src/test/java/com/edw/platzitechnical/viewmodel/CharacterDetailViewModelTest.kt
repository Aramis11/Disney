package com.edw.platzitechnical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.edw.data.domain.CharacterDetail
import com.edw.data.repository.CharacterDetailRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterDetailViewModelTest {

    private val dispatcher = Dispatchers.Unconfined
    private var characterDetailRepository: CharacterDetailRepositoryImpl = mockk()
    private lateinit var viewModel: CharacterDetailViewModel
    private val id = 308

    @Before
    fun onBefore() {
        viewModel = CharacterDetailViewModel(characterDetailRepository, dispatcher)
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
    }

    @Test
    fun `onSuccess consult the character's details from the service`(): Unit = runBlocking {
        val mData = getDummyCharacterDetail()
        coEvery { characterDetailRepository.charactersDetail(id) } answers { mData }

        viewModel.getDetailCharacter(id)

        coVerify(exactly = 1) { characterDetailRepository.charactersDetail(id) }
    }

    @Test
    fun `onFailure consult the character's details from the service`() = runBlocking {
        coEvery { characterDetailRepository.charactersDetail(id) }.throws(Exception())

        viewModel.getDetailCharacter(id)

        coVerify(exactly = 1) { characterDetailRepository.charactersDetail(id) }
        assertEquals(viewModel.characterDetail.value?.id, null)
    }


    private fun getDummyCharacterDetail(): CharacterDetail {
        return CharacterDetail(
            id = 1,
            name = "Peter",
            films = listOf(),
            tvShows = listOf(),
            videoGames = listOf(),
            enemies = listOf(),
            allies = listOf(),
            imageUrl = ""
        )
    }
}