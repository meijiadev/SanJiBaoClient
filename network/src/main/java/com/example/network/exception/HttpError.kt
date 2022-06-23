package com.example.network.exception


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 错误码以及含义处理
 */
enum class HttpError(val code:Int,val errorMsg:String) {
    UNKONW(-100,"未知错误"),
    JSON_PARSE_ERROR(1001,"Json 解析失败")

}