package com.example.network.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.network.HttpRequestCallback
import com.example.network.OnFailureCallback
import com.example.network.OnSuccessCallback
import com.example.network.OnUnitCallback
import com.example.network.exception.RequestException
import com.example.network.observer.IStateObserver
import com.example.network.response.BaseResponse


/**
 *    author : MJ
 *    time   : 2022/06/24
 *    desc   : livedata的拓展函数，重写observe（a,b）
 */

inline fun<T> LiveData<BaseResponse<T>>.observerState(
    owner: LifecycleOwner,
    crossinline callback: HttpRequestCallback<T>.() ->Unit
){
    val requestCallback=HttpRequestCallback<T>().apply(callback)
    observe(owner,object :IStateObserver<T>{
        override fun onStart() {
            requestCallback.startCallback?.invoke()
        }

        override fun onSuccess(data: T) {
            requestCallback.successCallback?.invoke(data)
        }

        override fun onFailure(e: RequestException) {
            requestCallback.failureCallback?.invoke(e)
        }

        override fun onEmpty() {
            requestCallback.emptyCallback?.invoke()
        }

        override fun onFinish() {
            requestCallback.finishCallback?.invoke()
        }
    })
}

inline fun <T> LiveData<BaseResponse<T>>.observeResponse(
    owner: LifecycleOwner,
    crossinline onStart: OnUnitCallback = {},
    crossinline onEmpty: OnUnitCallback = {},
    crossinline onFailure: OnFailureCallback = { e: RequestException -> },
    crossinline onFinish: OnUnitCallback = {},
    crossinline onSuccess: OnSuccessCallback<T>
) {
    observe(owner, object : IStateObserver<T> {
        override fun onStart() {
            onStart()
        }

        override fun onSuccess(data: T) {
            onSuccess(data)
        }

        override fun onEmpty() {
            onEmpty()
        }

        override fun onFailure(e: RequestException) {
            onFailure(e)
        }

        override fun onFinish() {
            onFinish()
        }
    })
}