package com.example.internshipsfera.data

data class Account(
    val name: String = "",
    val avatarUrl: String = "",
    var isSubscribe: Boolean = false,
    var id: Int = UNDEFINED_ID
    ) {

    companion object{
        const val UNDEFINED_ID = -1
    }
}