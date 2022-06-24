package com.example.sanjibaoclient.constants

import com.example.sanjibaoclient.BuildConfig

/**
 *    author : MJ
 *    time   : 2022/06/25
 *    desc   : 全局配置参数
 */
object AppConfig {

    /**
     * 用于存储登录的token，key
     */
    const val APP_TOKEN = "token"


    /**
     * token为空
     */
    const val TOKEN_NULL="null"


    /**
     * 当前是否为调试模式
     */
    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    /**
     * 获取当前构建的模式
     */
    fun getBuildType(): String {
        return BuildConfig.BUILD_TYPE
    }

    /**
     * 当前是否要开启日志打印功能
     */
    fun isLogEnable(): Boolean {
        return BuildConfig.LOG_ENABLE
    }

    /**
     * 获取当前应用的包名
     */
    fun getPackageName(): String{
        return BuildConfig.APPLICATION_ID
    }

    /**
     * 获取当前应用的版本名
     */
    fun getVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

    /**
     * 获取当前应用的版本码
     */
    fun getVersionCode(): Int {
        return BuildConfig.VERSION_CODE
    }

    /**
     * 获取服务器主机地址
     */
    fun getHostUrl(): String {
        return BuildConfig.HOST_URL
    }

}