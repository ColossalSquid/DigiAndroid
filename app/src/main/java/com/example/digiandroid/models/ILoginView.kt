package com.example.digiandroid.models

interface ILoginView<T> {

    fun showProgressBar()
    fun hideProgressBar()

    fun onSuccess(responseMessage: T)

    fun onError(errorResponseMessage: T)

    fun onFailure(errorResponseMessage: T)

}