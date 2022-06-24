package com.example.sanjibaoclient.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.architecture.viewmodel.BaseViewModel
import com.example.sanjibaoclient.network.Repository
import com.kunminx.architecture.ui.callback.UnPeekLiveData
import com.lingdu.arphakids.ext.logI


/**
 *    author : MJ
 *    time   : 2022/06/23
 *    desc   : 登录页面的viewModel
 */
class LoginViewModel :BaseViewModel() {
    /**
     * 登陆点击事件
     */
    private val loginAction=UnPeekLiveData<Boolean>()

    /**
     * 退出登录
     */
    private val logoutAction =UnPeekLiveData<Boolean>()

    private var userName:String=""

    private var password:String=""

    var token:String=" "

    val loginLiveData=loginAction.switchMap {
        Repository.login("root","Admin12#")
    }

    val logoutData=logoutAction.switchMap {
        Repository.getUserPermission(token)
    }

    /**
     * 点击去登陆
     */
    fun login(){
        loginAction.value=true
    }

    fun logout(){
        logoutAction.value=true
    }

}