package ru.maksewsha.testtask.data.network

import android.util.Log
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import ru.maksewsha.testtask.data.DataMapper
import ru.maksewsha.testtask.data.models.Character
import ru.maksewsha.testtask.data.models.Characters
import ru.maksewsha.testtask.domain.models.CharactersDomainModel
import ru.maksewsha.testtask.domain.repos.Repository
import javax.security.auth.callback.Callback

class NetworkRepository constructor(private val retrofitService: RetrofitService) : Repository {
    private val dataMapper = DataMapper()
    override suspend fun fetchData(): CharactersDomainModel {
        val response = retrofitService.getAllCharacters()
        val result = response.execute()
        return if (result.isSuccessful){
            dataMapper.mapFromEntity(Characters.Success(result.body() as List<Character>))
        } else {
            dataMapper.mapFromEntity(Characters.Fail(result.message()))
        }
    }
}