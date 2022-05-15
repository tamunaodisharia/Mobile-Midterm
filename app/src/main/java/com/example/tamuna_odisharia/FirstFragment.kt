package com.example.tamuna_odisharia

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tamuna_odisharia.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        sharedPref = activity?.getSharedPreferences("name", Context.MODE_PRIVATE)!!
        val edit = sharedPref.edit()

        binding.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.rightButton.setOnClickListener {
            val name = binding.PersonName.text.toString()
            edit?.putString("Your_name", name)?.apply()
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}