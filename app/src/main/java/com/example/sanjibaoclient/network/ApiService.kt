package com.example.sanjibaoclient.network

import com.example.network.response.ApiResponse
import com.example.sanjibaoclient.login.LoginData
import com.example.sanjibaoclient.login.LoginRequestBody
import com.example.sanjibaoclient.login.PermissionData
import retrofit2.http.*

/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 网络请求接口列表
 */
interface ApiService {

    /**
     * 登录
     */
    @POST("api/login")
    suspend fun login(
        @Body loginBody: LoginRequestBody
    ): ApiResponse<LoginData>

    /**
     * 退出登录
     */
    @POST("api/logout")
    suspend fun logout(
        @Header("token")
        token: String
    ): ApiResponse<String>

    /**
     * 获取用户权限
     */
    @GET("api/permission")
    suspend fun getUserPermission(
        @Header("token")
        token: String
    ): ApiResponse<List<PermissionData>>




}