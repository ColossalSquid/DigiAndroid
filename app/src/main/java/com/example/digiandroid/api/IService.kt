package com.example.digiandroid.api

import com.example.digiandroid.models.BaseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("username") user : String,
              @Field("password") password: String): Call<ResponseBody>


    @GET("getCategories.php")
    fun getCategories(): Call<BaseModel>


}