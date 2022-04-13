package com.example.digiandroid.models

interface IResponseMessage<T> {



    fun onSuccess(responseMessage: String)

    fun onError(errorResponseMessage: String)

    fun onFailure(errorResponseMessage: String)
}