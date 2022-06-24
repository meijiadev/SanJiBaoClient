package com.example.network.exception

import com.example.network.response.BaseResponse
import java.lang.Exception


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 网络请求错误
 */
class RequestException(
    val code:Int?=0,
    val errorMsg:String?="",
    val error:String?=null
) :Exception(){
    constructor(response: BaseResponse<*>):this(
        response.code,
        response.message,
        response.message
    )

    constructor(httpError: HttpError, error: String?):this(
        httpError.code,
        httpError.errorMsg,
        error
    )

    override fun toString(): String {
        return "code:$code \n" +
                "errorMsg:$errorMsg \n"+
                "error:$error"
    }
}