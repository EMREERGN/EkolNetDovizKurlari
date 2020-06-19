package com.emreergun.ekolnetdovizkurlari.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreergun.ekolnetdovizkurlari.model.DovizModel
import com.emreergun.ekolnetdovizkurlari.retrofit.IApi
import com.emreergun.ekolnetdovizkurlari.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {


    fun getDovizDatas(): LiveData<DovizModel> {
        val retrofit= RetrofitClient.instance
        val api=retrofit.create(IApi::class.java)

        val data= MutableLiveData<DovizModel>()
        api.getDoviz("TRY").enqueue(object :Callback<DovizModel>{
            override fun onFailure(call: Call<DovizModel>, t: Throwable) {
                Log.e("Emre","${t.message} \n ${t.cause}")
            }
            override fun onResponse(call: Call<DovizModel>, response: Response<DovizModel>) {
                data.value=response.body()
                Log.i("Emre",data.value.toString())
            }
        })
        return data
    }





}
