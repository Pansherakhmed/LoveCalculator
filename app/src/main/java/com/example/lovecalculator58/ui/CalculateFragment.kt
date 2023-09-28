package com.example.lovecalculator58.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator58.R
import com.example.lovecalculator58.databinding.FragmentCalculateBinding
import com.example.lovecalculator58.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                RetrofitService().api.countCompatibility(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).enqueue(object : Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        findNavController().navigate(R.id.resultFragment, bundleOf(KEY to response.body()?.percentage))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })


            }
        }
    }

    companion object {
        const val KEY = "result"
    }

}