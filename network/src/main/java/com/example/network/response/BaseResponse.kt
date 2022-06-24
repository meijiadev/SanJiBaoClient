package com.example.network.response

import java.io.Serializable

/**
 * @desc 网络请求返回值基类
 * @author Mj
 * @time 2022/06/23
 */
abstract class BaseResponse<T> {
    abstract val getSuccess: Boolean
    abstract val data: T?
    abstract val code: Int?
    abstract val message: String?

}