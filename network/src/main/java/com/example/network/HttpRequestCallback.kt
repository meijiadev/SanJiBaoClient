package com.example.network

import com.example.network.exception.RequestException


/**
 *    author : MJ
 *    time   :2022/06/23
 *    desc   :网络请求回调
 */
// 类型别名将比较复杂的类型参数或者函数重新命名
typealias OnSuccessCallback<T> = (data: T) -> Unit
typealias OnFailureCallback = (e: RequestException) -> Unit
typealias OnUnitCallback = () -> Unit

class HttpRequestCallback<T> {

    var startCallback: OnUnitCallback? = null



}