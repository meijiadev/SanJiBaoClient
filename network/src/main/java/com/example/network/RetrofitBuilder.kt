package com.example.network

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform


const val HTTP_LOG_TAG_REQUEST="okhttp_request"
const val HTTP_LOG_TAG_RESPONSE="okhttp_response"
object RetrofitBuilder :BaseRetrofitBuilder() {
    override fun handlerOkhttpClientBuilder(builder: OkHttpClient.Builder) {

    }

    override fun initLoggingInterceptor()=LoggingInterceptor
        .Builder()
        .setLevel(Level.BASIC)
        .log(Platform.INFO)
        .request(HTTP_LOG_TAG_REQUEST)
        .response(HTTP_LOG_TAG_RESPONSE)
        .build()


}