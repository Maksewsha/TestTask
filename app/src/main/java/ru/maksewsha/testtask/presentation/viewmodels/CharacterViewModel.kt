package ru.maksewsha.testtask.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.maksewsha.testtask.domain.usecases.GetCharactersListUseCase
import ru.maksewsha.testtask.presentation.logic.PresentationMapper
import ru.maksewsha.testtask.presentation.models.CharacterPresentation
import ru.maksewsha.testtask.presentation.models.CharactersUIModel

class CharacterViewModel(private val getCharactersListUseCase: GetCharactersListUseCase) :
    ViewModel() {
    private val _characterList = MutableLiveData<List<CharacterPresentation>>()
    val characterList = _characterList as LiveData<List<CharacterPresentation>>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    private var job: Job? = null

    private val presentationMapper = PresentationMapper()

    fun getAllCharacters() {

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = presentationMapper.mapFromEntity(getCharactersListUseCase.execute() as CharactersDomainModel.Success)
            when (response) {
                is CharactersUIModel.Success -> {
                    _characterList.postValue(response.data)
                }
                is CharactersUIModel.Fail -> {
                    _errorMessage.postValue(response.errorMessage)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
