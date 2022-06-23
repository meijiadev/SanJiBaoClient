package com.example.sanjibaoclient.network

import com.example.network.RetrofitBuilder


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 统一接口请求类
 */
object NetworkDataSource {

    private val apiService: ApiService =RetrofitBuilder.create(ApiService::class.java)

    suspend fun login(username:String,password:String) = apiService.login(username,password)



}