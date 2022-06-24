package com.example.sanjibaoclient.data


/**
 *    author : MJ
 *    time   : 2022/06/24
 *    desc   : 用户权限信息列表
 */
data class PermissionData(
    val name: String,
    val parentId: String,
    val permissionId: String,
    val type: String,
    val childPermissions: List<PermissionData>
)

