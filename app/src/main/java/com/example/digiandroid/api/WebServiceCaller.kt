package com.example.digiandroid.api

import android.util.Log
import com.example.digiandroid.models.IResponseMessage
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class WebServiceCaller {

    var iservice: IService = ApiConfig.retrofit.create(IService::class.java)
    fun login(username: String, password: String, listener: IResponseMessage<String>){
        iservice.login(username, password).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                TODO("Not yet implemented")
                Log.e("","")
                listener.onSuccess(response.body().toString())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                TODO("Not yet implemented")
                Log.e("","")
                listener.onFailure(t.message.toString())
            }

        })
    }
}
