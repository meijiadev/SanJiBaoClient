package com.example.architecture.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import com.example.architecture.action.ToastAction
import com.lingdu.arphakids.ext.logI



/**
 *    author : MJ
 *    time   : 2022/02/25
 *    desc   : BaseViewModel
 */
open class BaseViewModel :ViewModel(),LifecycleOwner, ToastAction {


    @SuppressLint("StaticFieldLeak")
    private  val mRegistry:LifecycleRegistry = LifecycleRegistry(this)

    init {
        mRegistry.currentState=Lifecycle.State.CREATED
    }

    override fun onCleared() {
        super.onCleared()
        mRegistry.currentState=Lifecycle.State.DESTROYED
        logI("销毁${this.javaClass.simpleName}")
    }
    override fun getLifecycle(): Lifecycle {
        return mRegistry
    }

    /**
     * 手动清除内存中的数据
     */
    open fun onHandClear(){

    }


}