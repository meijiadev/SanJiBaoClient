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

    /**
     * 获取账号权限
     */
    private val permissionAction=UnPeekLiveData<Boolean>()

    private var userName:String=""

    private var password:String=""

    var token:String=" "


    val loginLiveData=loginAction.switchMap {
        Repository.login(userName,password)
    }

    val reqPerData=permissionAction.switchMap {
        Repository.getUserPermission(token)

    }


    /**
     * 点击去登陆
     */
    fun login(account:String,password:String){
        userName=account
        this.password=password
        loginAction.value=true
    }

    fun requestPer(){
        permissionAction.value=true
    }

}