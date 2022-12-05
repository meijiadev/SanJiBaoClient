package com.example.sanjibaoclient.login

import com.example.architecture.ui.activity.BaseVmDbActivity
import com.example.network.ext.observerState
import com.example.sanjibaoclient.R
import com.example.sanjibaoclient.app.AppVmDbActivity
import com.example.sanjibaoclient.databinding.ActivityLoginBinding
import com.hjq.gson.factory.GsonFactory
import com.lingdu.arphakids.ext.logI
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  author: MJ
 *  desc: 登录页面
 *  time: 2022/06/23
 */
class LoginActivity : AppVmDbActivity<LoginViewModel, ActivityLoginBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView() {
        mDatabind.loginModel = mViewModel
    }

    override fun initData() {
        mViewModel.loginLiveData.observerState(this) {
            onStart {
                logI("开始请求")
            }
            onSuccess {
                logI("result:$it")
                mViewModel.token = "${it.tokenType} ${it.token}"
                toast("登录成功！")
                mViewModel.requestPer()
            }

            onFailure {
                logI("请求失败:${it.toString()}")
            }

        }

        mViewModel.reqPerData.observerState(this) {
            onSuccess {
                logI("权限列表：$" + it.size)
            }
            onFailure {
                logI("请求失败:${it.toString()}")
            }
        }

        mDatabind.loginBt.setOnClickListener {

        }

        clickAction()
    }

    /**
     * 点击事件
     */
    private fun clickAction() {
        mDatabind.loginBt.setOnClickListener {
            val account = mDatabind.accountEt.text.toString().trim()
            val password = mDatabind.passwordEt.text.toString().trim()
            if (account.isNullOrEmpty()){
                   toast("请输入用户名")
                return@setOnClickListener
            }

            if (password.isNullOrEmpty()){
                toast("请输入密码")
                return@setOnClickListener
            }
            mViewModel.login(account,password)

        }
    }


}