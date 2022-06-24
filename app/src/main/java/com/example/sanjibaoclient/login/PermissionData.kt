package com.example.sanjibaoclient.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 *    author : MJ
 *    time   : 2022/06/24
 *    desc   : 权限信息列表
 */
data class PermissionData(
    val name: String,
    val parentId: String,
    val permissionId: String,
    val type: String,
    val childPermissions: List<PermissionData>
)

