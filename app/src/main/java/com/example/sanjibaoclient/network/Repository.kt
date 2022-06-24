package com.example.sanjibaoclient.network

import com.example.network.repository.BaseRepository


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 数据请求，数据处理后返回相关数据
 */
object Repository : BaseRepository() {

    /**
     * 登录
     */
    fun login(name:String,pw:String)=request {
        NetworkDataSource.login(name,pw)
    }

    /**
     * 退出登录
     */
    fun logout(token:String)=request {
        NetworkDataSource.logout(token)
    }

    /**
     * 获取用户权限信息
     */
    fun getUserPermission(token: String)=request {
        NetworkDataSource.getUserPermission(token)
    }


}
