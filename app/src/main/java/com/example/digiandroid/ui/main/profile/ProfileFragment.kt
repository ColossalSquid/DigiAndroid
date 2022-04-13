package com.example.digiandroid.ui.main.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digiandroid.R
import com.example.digiandroid.databinding.FragmentProfileBinding
import com.example.digiandroid.ui.login.LoginActivity

class ProfileFragment : Fragment() {


    lateinit var binding: FragmentProfileBinding;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)


        binding.btnLogin.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(activity , LoginActivity::class.java)
            startActivity(intent)
        })
        return binding.root

    }


}