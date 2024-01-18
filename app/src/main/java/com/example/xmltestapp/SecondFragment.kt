package com.example.xmltestapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.xmltestapp.databinding.SecondFragmentBinding

class SecondFragment : Fragment(R.layout.second_fragment) {
    private lateinit var binding: SecondFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val name = requireArguments().getString("name")

        binding = SecondFragmentBinding.inflate(inflater, container, false)
        binding.tv.text = name

        Log.d("Main Data c", name.toString())
        binding.btn.setOnClickListener {
            binding.tv.text = name
        }
        return binding.root
    }


}