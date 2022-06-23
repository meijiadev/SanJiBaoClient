package com.example.sanjibaoclient.login

data class LoginData(
    val token: String,
    val tokenType: String,
    val userInfo: UserInfo
)
data class UserInfo(
    val expiredDate: Any,
    val fullName: String,
    val roleType: String,
    val userId: String,
    val username: String
)