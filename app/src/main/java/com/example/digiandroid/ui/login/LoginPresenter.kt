package com.example.digiandroid.ui.login

import com.example.digiandroid.models.ILoginView
import com.example.digiandroid.models.IResponseMessage

class LoginPresenter: IResponseMessage<String> {


    var interactor: LoginInteractor = LoginInteractor()
    lateinit var loginView : ILoginView<String>


    constructor(view: ILoginView<String>){
        loginView = view
    }


    fun login(user: String, pass: String) {
        loginView.showProgressBar()
        interactor.login(user, pass, this)
    }

    override fun onSuccess(responseMessage: String) {
        loginView.hideProgressBar()
        loginView.onSuccess("")
    }

    override fun onError(errorResponseMessage: String) {
        loginView.hideProgressBar()
        loginView.onError("")
    }

    override fun onFailure(errorResponseMessage: String) {
        loginView.hideProgressBar()
        loginView.onFailure("")
    }

}