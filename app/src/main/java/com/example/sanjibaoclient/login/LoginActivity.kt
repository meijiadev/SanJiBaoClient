package com.example.sanjibaoclient.login

import com.example.architecture.ui.activity.BaseVmDbActivity
import com.example.sanjibaoclient.R
import com.example.sanjibaoclient.databinding.ActivityLoginBinding

/**
 *  author: MJ
 *  desc: 登录页面
 *  time: 2022/06/23
 */
class LoginActivity : BaseVmDbActivity<LoginViewModel,ActivityLoginBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView() {
        mDatabind.loginModel=mViewModel
    }

    override fun initData() {
        mViewModel.loginLiveData.observe(this){
        }
    }


}