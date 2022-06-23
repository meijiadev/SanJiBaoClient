package com.example.network.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.network.response.BaseResponse
import java.security.acl.Owner


/**
 *    author : MJ
 *    time   :
 *    desc   :
 */

inline fun<T> LiveData<BaseResponse<T>>.observerState(
    owner: LifecycleOwner,

){

}