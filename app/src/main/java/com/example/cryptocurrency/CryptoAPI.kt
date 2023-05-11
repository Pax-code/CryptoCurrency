package com.example.cryptocurrency

import com.example.cryptocurrency.model.Crypto
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET



interface CryptoAPI {
    @GET("coins?apiKey=${BuildConfig.API_KEY}")
    fun  getData(): Observable<Crypto>
}