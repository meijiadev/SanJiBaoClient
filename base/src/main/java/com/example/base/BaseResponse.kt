package com.example.base

abstract class BaseResponse<T> {
    abstract val getSuccess: Boolean
    abstract val data: T?
    abstract val errorCode: Int?
    abstract val errorMsg: String?

}