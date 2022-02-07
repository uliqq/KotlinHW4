package com.geektech.kotlinhw4.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.geektech.kotlinhw4.databinding.FragmentSecondBinding
import com.geektech.kotlinhw4.ui.view_models.SharedViewModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.counts.observe(viewLifecycleOwner,  {
            initViews(it)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun initViews(list: ArrayList<String>) {
        var plus = 0
        for (i in list) {
            if (i == "+"){
                plus++
            }
        }
        val minus = list.size - plus
        binding.tvCounts.text = "Plus: $plus --- Minus: $minus"
    }
}