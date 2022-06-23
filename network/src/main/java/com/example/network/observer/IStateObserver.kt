package com.example.network.observer

import androidx.lifecycle.Observer
import com.example.network.exception.RequestException
import com.example.network.response.*


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 自定义Observer,用于监听LiveData的值得变化
 */
interface IStateObserver<T> : Observer<BaseResponse<T>> {
    override fun onChanged(t: BaseResponse<T>?) {
        when (t) {
            is StartResponse -> {
                onStart()
                return
            }
            is SuccessResponse -> onSuccess(t.data)
            is EmptyResponse -> onEmpty()
            is FailureResponse -> onFailure(t.exception)
        }
        onFinish()
    }

    /**
     *  请求开始
     */
    fun onStart()

    /**
     * 请求成功
     */
    fun onSuccess(data: T)

    /**
     *请求失败
     */
    fun onFailure(e: RequestException)

    /**
     * 请求成功，但是data为空
     */
    fun onEmpty()

    /**
     * 请求结束
     */
    fun onFinish()

}