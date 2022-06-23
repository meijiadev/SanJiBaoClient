package com.example.sanjibaoclient.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.sanjibaoclient.network.Repository
import com.kunminx.architecture.ui.callback.UnPeekLiveData


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 登录页面的viewModel
 */
class LoginViewModel :ViewModel() {
    /**
     * 登陆点击事件
     */
    private val loginAction=UnPeekLiveData<Boolean>()

    private var userName:String=""

    private var password:String=""

    val loginLiveData=loginAction.switchMap {

        Repository.login(userName,password)
    }

    /**
     * 点击去登陆
     */
    fun login(){
        loginAction.value=true
    }

}