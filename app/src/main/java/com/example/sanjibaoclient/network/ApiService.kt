package com.example.sanjibaoclient.network

import com.example.network.response.ApiResponse
import com.example.sanjibaoclient.login.LoginData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 网络请求接口列表
 */
interface ApiService {
    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("username")
        userName:String,
        @Field("password")
        password:String
    ):ApiResponse<LoginData>



}