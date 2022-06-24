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
open class BaseViewModel :ViewModel(), ToastAction {


    override fun onCleared() {
        super.onCleared()

    }


    /**
     * 手动清除内存中的数据
     */
    open fun onHandClear(){

    }


}