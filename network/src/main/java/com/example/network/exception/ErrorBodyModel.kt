package com.example.network.exception


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 特殊情况
 */
data class ErrorBodyModel(
    val error: String? = "",
    val msg: String? = "",
    val success: Boolean? = false
)