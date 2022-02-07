package com.geektech.kotlinhw4.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity, private val list: ArrayList<Fragment>): FragmentStateAdapter(activity)  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment = list[position]
}