package com.lingdu.arphakids.ext


import com.orhanobut.logger.Logger
import java.lang.Exception


/**
 *    author : MJ
 *    time   : 2022/06/14
 *    desc   : 对Logger 日志框架进行简单的封装便于统一处理msg为null的情况
 */

fun logd(msg:String?){
    if (msg!=null){
        Logger.d(msg)
    }else{
        Logger.d("null")
    }
    
}

fun logd(tag:String, msg: String?){
    if (msg!=null){
        Logger.d(tag,msg)
    }else{
        Logger.d(tag,"null")
    }
}

fun logI(msg: String?){
    if (msg!=null){
        Logger.i(msg)
    }else{
        Logger.i("null")
    }
}
fun logI(tag:String,msg: String?){
    if (msg!=null){
        Logger.i(tag,msg)
    }else{
        Logger.i(tag,"null")
    }
}

fun loge(msg: String?){
    if (msg!=null){
        Logger.e(msg)
    }else{
        Logger.e("null")
    }
}

fun loge(msg:Exception?){
    if (msg!=null){
        Logger.e(msg?.message?:"error null")
    }
}

fun loge(msg:Throwable?){
    if (msg!=null){
        Logger.e(msg?.message?:"error null")
    }
}

fun logJson(json:String){
    Logger.json(json)
}