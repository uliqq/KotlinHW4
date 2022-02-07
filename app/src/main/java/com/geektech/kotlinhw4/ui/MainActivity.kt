package com.geektech.kotlinhw4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.kotlinhw4.databinding.ActivityMainBinding
import com.geektech.kotlinhw4.ui.fragments.FirstFragment
import com.geektech.kotlinhw4.ui.fragments.SecondFragment
import com.geektech.kotlinhw4.ui.fragments.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabTitles = listOf("First", "Second", "Third")

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val list = arrayListOf(FirstFragment(), SecondFragment(), ThirdFragment())
        val adapter = ViewPagerAdapter(this, list)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}