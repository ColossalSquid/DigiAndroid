package com.example.digiandroid.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.digiandroid.R
import com.example.digiandroid.databinding.ActivityLoginBinding
import com.example.digiandroid.models.ILoginView
import okhttp3.ResponseBody

class LoginActivity : AppCompatActivity(), ILoginView<String>{

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)

            //login button
        binding.btnLogin.setOnClickListener {

            var username = binding.edtUsername.text.toString()
            var password = binding.edtPassword.text.toString()
            presenter.login(username, password)
        }
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onSuccess(responseMessage: String) {
        Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
    }

    override fun onError(errorResponseMessage: String) {
        Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
    }

    override fun onFailure(errorResponseMessage: String) {
        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
    }
}