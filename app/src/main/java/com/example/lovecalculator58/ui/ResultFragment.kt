package com.example.lovecalculator58.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator58.databinding.FragmentResultBinding
import com.example.lovecalculator58.ui.CalculateFragment.Companion.KEY

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val result =  arguments?.getString(KEY)
        binding.tvResult.text = "$result%"
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            btnAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }


}