package com.example.architecture.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.action.*
import com.example.architecture.ext.getVmClazz
import com.example.architecture.viewmodel.BaseViewModel

/**
 *    author : MJ
 *    time   : 2022/04/11
 *    desc   : ViewModelActivity基类，把ViewModel注入进来了
 */
abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity(), ActivityAction,
    HandlerAction, KeyboardAction,
    BundleAction {

    /**
     * 是否需要使用DataBinding
     */
    private var isUserDb = false

    /**
     * 当前页面泛型的viewModel
     */
    lateinit var mViewModel: VM

    abstract fun layoutId(): Int

    abstract fun initView()

    abstract fun initData()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserDb) {
            if (layoutId() > 0) {
                setContentView(layoutId())
                initSoftKeyboard()
            }
        } else {
            initDataBind()
        }
        init()
    }

    protected open fun init() {
        mViewModel = createViewModel()
        initView()
        initData()

    }

    /**
     * 是否使用DataBinding
     */
    fun userDataBinding(isUserDb: Boolean) {
        this.isUserDb = isUserDb
    }

    /**
     * 供子类BaseVmDbActivity 初始化DataBinding
     */
    open fun initDataBind() {

    }

    open fun onNetworkStateChanged(netState: Boolean) {

    }

    /**
     *创建ViewModel对象
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }



    override fun getBundle(): Bundle? {
        return intent.extras
    }

    /**
     * 初始化软键盘
     */
    @SuppressLint("RestrictedApi")
    protected open fun initSoftKeyboard() {
        // 点击外部隐藏软键盘，提升用户体验
        getContentView()?.setOnClickListener {
            // 隐藏软键，避免内存泄漏
            hideKeyboard(currentFocus)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        removeCallbacks()
    }


    override fun finish() {
        super.finish()
        // 隐藏软键，避免内存泄漏
        if (layoutId()>0){
            hideKeyboard(currentFocus)
        }
    }


    /**
     * 和 setContentView 对应的方法
     */
    open fun getContentView(): ViewGroup? {
        return findViewById(Window.ID_ANDROID_CONTENT)
    }

    override fun getContext(): Context {
        return this
    }

    override fun startActivity(intent: Intent?) {
        return super<AppCompatActivity>.startActivity(intent)
    }

}
