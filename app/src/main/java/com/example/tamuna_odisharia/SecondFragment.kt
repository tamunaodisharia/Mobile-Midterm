package com.example.tamuna_odisharia

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tamuna_odisharia.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var sharedPref: SharedPreferences
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.leftButton.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        sharedPref = activity?.getSharedPreferences("name", Context.MODE_PRIVATE)!!
        val name = sharedPref.getString("Your_name",null)

        if(name!!.isNotEmpty()){
            binding.userName.text = "Hello, $name"
        }else{
            binding.userName.text = "Hello, Null"
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}