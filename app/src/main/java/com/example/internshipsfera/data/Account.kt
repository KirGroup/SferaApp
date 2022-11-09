package com.example.internshipsfera.data

data class Account(
    var name: String = "",
    var avatarUrl: String? = null,
    val id: Int,
    var isSubscribe: Boolean = false
)