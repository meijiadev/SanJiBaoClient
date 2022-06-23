package com.example.sanjibaoclient.network

import com.example.network.repository.BaseRepository


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 数据请求，数据处理后返回相关数据
 */
object Repository : BaseRepository() {

    fun login(name:String,pw:String)=request {
        NetworkDataSource.login(name,pw)
    }
}
