package ru.maksewsha.testtask.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maksewsha.testtask.data.network.NetworkRepository
import ru.maksewsha.testtask.data.network.RetrofitService
import ru.maksewsha.testtask.domain.usecases.GetCharactersListUseCase

class CharacterViewModelFactory(): ViewModelProvider.Factory {

    private val retrofitService by lazy(LazyThreadSafetyMode.NONE){
        RetrofitService.getInstance()
    }

    private val networkRepository by lazy(LazyThreadSafetyMode.NONE){
        NetworkRepository(retrofitService)
    }

    private val getCharactersListUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetCharactersListUseCase(networkRepository)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterViewModel(getCharactersListUseCase) as T
    }

}