package com.example.digiandroid.ui.login

import com.example.digiandroid.api.WebServiceCaller
import com.example.digiandroid.models.IResponseMessage
import okhttp3.ResponseBody

class LoginInteractor {


    fun login(user: String, pass: String, listener: IResponseMessage<String>) {
        var webService = WebServiceCaller()
        webService.login(user, pass, object : IResponseMessage<String> {
            override fun onSuccess(responseMessage: String) {
                listener.onSuccess(responseMessage)
            }

            override fun onError(errorResponseMessage: String) {
                listener.onError(errorResponseMessage)
            }

            override fun onFailure(errorResponseMessage: String) {
                listener.onFailure(errorResponseMessage)
            }


        })

    }


}