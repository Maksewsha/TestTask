package ru.maksewsha.testtask.data.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.maksewsha.testtask.data.models.Character

interface RetrofitService {
    @GET("/api/characters")
    fun getAllCharacters(): Call<List<Character>>

    companion object{
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://breakingbadapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}