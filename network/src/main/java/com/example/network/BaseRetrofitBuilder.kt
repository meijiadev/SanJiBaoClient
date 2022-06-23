package com.example.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CALL_TIME_OUT=8L
private const val BASE_URL="http://124.71.223.195:9900/"
abstract class BaseRetrofitBuilder {
    private val okhttpClient:OkHttpClient by lazy {
        val builder=OkHttpClient.Builder()
            .callTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
            .connectTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
            .readTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
            .writeTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        initLoggingInterceptor()
        handlerOkhttpClientBuilder(builder)
        builder.build()
    }

    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()

    /**
     * 生成API接口类
     */
    fun <T> create(service:Class<T>):T=retrofit.create(service)

    /**
     * 内联函数
     */
    inline fun <reified T> create():T=create(T::class.java)

    /**
     *子类自定义OkHttpClient
     */
    abstract fun handlerOkhttpClientBuilder(builder:OkHttpClient.Builder)

    /**
     *配置日志拦截器
     */
    abstract fun initLoggingInterceptor():Interceptor?


}