package com.simplesoftware.applicationworkapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private val retrofit: Retrofit

    fun productApi(): ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

    companion object{

        private const val BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var retrofitConfig: RetrofitConfig? = null

        @get:Synchronized
        val instance: RetrofitConfig?
            get(){
                if (retrofitConfig == null){
                    retrofitConfig = RetrofitConfig()
                }
                return retrofitConfig
            }
    }

    init {
        retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}