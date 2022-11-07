package com.example.internshipsfera.domain

import androidx.lifecycle.LiveData

interface AccountListRepository {

    fun addAccount(account: Account)

    fun deleteAccount(account: Account)

    fun editAccount(account: Account)

    fun getAccount(accountId: Int): Account

    fun getAccountList(): LiveData<List<Account>>

}