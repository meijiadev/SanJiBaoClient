package com.example.sanjibaoclient.network

import com.example.network.RetrofitBuilder
import com.example.sanjibaoclient.data.request.LoginRequestBody


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 统一接口请求类
 */
object NetworkDataSource {

    private val apiService=RetrofitBuilder.create<ApiService>()

    suspend fun login(username:String,password:String) = apiService.login(LoginRequestBody(username, password))

    suspend fun logout(token:String)= apiService.logout(token)

    suspend fun getUserPermission(token: String) = apiService.getUserPermission(token)



}