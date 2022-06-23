package com.example.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.network.exception.RequestException
import com.example.network.exception.handleException
import com.example.network.response.*
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 数据源基类
 */
abstract class BaseRepository {

    /**
     * 请求数据
     */
    fun <T> request(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend () -> BaseResponse<T>
    ): LiveData<BaseResponse<T>> = liveData(context) {
        runCatching {
            // 先发射开始请求的消息，告知用户已经开始请求接口了
            emit(StartResponse())
            // 正式执行网络请求接口操作
            block()
        }.onSuccess {
            // 网络请求成功
            emit(
                when (it.getSuccess) {
                    // 返回值错误
                    true -> checkEmptyResponse(it.data)
                    // 返回值失败
                    false-> FailureResponse(handleException(RequestException(it)))
                }
            )
        }.onFailure {
            // 网络请求错误
            emit(FailureResponse(handleException(it)))
        }
    }

    /**
     * 检查数据源是否是空
     */
    private fun <T> checkEmptyResponse(data: T?): ApiResponse<T> =
        if (data == null || (data is List<*> && (data as List<*>).isEmpty())) {
            EmptyResponse()
        } else {
            SuccessResponse(data)
        }


}