package com.example.network

import com.example.network.exception.RequestException


/**
 *    author : MJ
 *    time   :2022/06/23
 *    desc   :网络请求回调
 */
// 将lambda表达式起别名（类型别名）
typealias OnSuccessCallback<T> = (data: T) -> Unit
typealias OnFailureCallback = (e: RequestException) -> Unit
typealias OnUnitCallback = () -> Unit

class HttpRequestCallback<T> {
    // 定义lambda回调方法
    var startCallback: OnUnitCallback? = null

    var successCallback: OnSuccessCallback<T>? = null

    var emptyCallback: OnUnitCallback? = null

    var failureCallback: OnFailureCallback? = null

    var finishCallback: OnUnitCallback? = null


    fun onStart(block:OnUnitCallback){
        startCallback=block
    }

    fun onSuccess(block:OnSuccessCallback<T>){
        successCallback=block
    }

    fun onEmpty(block: OnUnitCallback /* = () -> kotlin.Unit */){
        emptyCallback=block
    }

    fun onFailure(block:OnFailureCallback){
        failureCallback=block
    }

    fun onFinish(block: OnUnitCallback /* = () -> kotlin.Unit */){
        finishCallback=block
    }

}