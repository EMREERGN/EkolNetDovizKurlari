package com.emreergun.ekolnetdovizkurlari.retrofit

import com.emreergun.ekolnetdovizkurlari.model.DovizModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {

   /* @GET("latest")
    fun getDoviz(@Query("access_key") access_key: String): Call<DovizModel>*/

    @GET("latest")
    fun getDoviz(@Query ("base") base:String): Call<DovizModel>
}