package com.example.base

/**
 * @desc:请求结果
 * @time:2022/06/23
 * @author MJ
 */
open class ApiResponse<T>(
    override val data: T?=null,
    override val errorCode: Int?=null,
    override val errorMsg: String?=null,

):BaseResponse<T>(){
    override val getSuccess: Boolean
        get() = errorCode==0
}

/**
 * 开始请求
 */
class StartResponse<T> :ApiResponse<T>()

/**
 * 请求成功
 */
data class SuccessResponse<T>(override val data: T):ApiResponse<T>(data)

/**
 * 返回为空
 */
class EmptyResponse<T>():ApiResponse<T>()

