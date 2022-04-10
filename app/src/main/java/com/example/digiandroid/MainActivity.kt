package com.example.digiandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.digiandroid.databinding.ActivityMainBinding
import com.example.digiandroid.ui.main.adapter.TabsAdapter
import com.example.digiandroid.ui.main.category.CategoryFragment
import com.example.digiandroid.ui.main.home.HomeFragment
import com.example.digiandroid.ui.main.profile.ProfileFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        binding.bottomBar.setOnItemSelectedListener {
//            when(it){
//                0 -> binding.viewPager.currentItem = 0
//                1 -> binding.viewPager.currentItem = 1
//                2 -> binding.viewPager.currentItem = 2
//            }
//        }
//        var fragmentsList = mutableListOf<Fragment>(HomeFragment(), CategoryFragment(), ProfileFragment())
//        var adapter = TabsAdapter(this, fragmentsList)
//        binding.viewPager.adapter = adapter

        //default selected fragment
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()
        binding.bottomBar.setOnItemSelectedListener {
            when(it){
                0-> supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()
                1-> supportFragmentManager.beginTransaction().replace(R.id.frame_container, CategoryFragment()).commit()
                2-> supportFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()
            }

        }
    }
}