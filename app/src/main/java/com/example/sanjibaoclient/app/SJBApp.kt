package com.example.sanjibaoclient.app

import com.example.architecture.BaseApplication
import com.example.sanjibaoclient.constants.AppConfig
import com.hjq.toast.ToastUtils
import com.hjq.toast.style.WhiteToastStyle
import com.orhanobut.logger.*


/**
 *    author : MJ
 *    time   : 2022/06/24
 *    desc   : 程序入口
 */
class SJBApp : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        initSdk()
    }

    private fun initSdk() {
        if (AppConfig.isLogEnable()) {
            val formatStrategy = PrettyFormatStrategy
                .newBuilder()
                .showThreadInfo(false)
                .methodOffset(1)
                .methodCount(2)
                .tag("sjb-debug")
                .build()
            Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
        } else {
            val formatStrategy = CsvFormatStrategy.newBuilder()
                .tag("sjb-release")
                .build()
            Logger.addLogAdapter(DiskLogAdapter(formatStrategy))
        }


        ToastUtils.init(this)
        ToastUtils.setStyle(WhiteToastStyle())
    }
}