package com.example.network.exception

import com.google.gson.Gson
import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.net.UnknownHostException


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 处理各种报错信息并分类
 */

fun handleException(throwable: Throwable) = when (throwable) {
    is UnknownHostException -> RequestException(HttpError.UNKONW, throwable.message)
    is HttpException -> {
        val errorModel = throwable.response()?.errorBody()?.string()?.run {
            Gson().fromJson(this, ErrorBodyModel::class.java)
        } ?: ErrorBodyModel()
        RequestException(errorMsg = errorModel.msg, error = errorModel.error)
    }
    is JsonParseException -> RequestException(HttpError.JSON_PARSE_ERROR, throwable.message)
    is RequestException -> throwable
    else -> RequestException(HttpError.UNKONW, throwable.message)
}