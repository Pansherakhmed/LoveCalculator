package com.example.lovecalculator58

import com.example.lovecalculator58.model.LoveModel

interface MainView {
    fun changeFragment(loveModel: LoveModel)
    fun showError(error: String)
}