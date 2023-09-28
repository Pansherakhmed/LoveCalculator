package com.example.lovecalculator58.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//'https://love-calculator.p.rapidapi.com/getPercentage'
//'X-RapidAPI-Key': '4c8a3cb757mshe90fc93a11ebc59p10d220jsn346674f151e9',
//    'X-RapidAPI-Host': 'love-calculator.p.rapidapi.com'

interface LoveApi {
    @GET("getPercentage")
    fun countCompatibility(
        @Query("fname") firstName: String, @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "4c8a3cb757mshe90fc93a11ebc59p10d220jsn346674f151e9",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}