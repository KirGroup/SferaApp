package com.example.internshipsfera.domain

import androidx.lifecycle.LiveData
import com.example.internshipsfera.data.Account

interface AccountListRepository {

    fun addAccount(account: Account)

    fun deleteAccount(account: Account)

    fun editAccount(account: Account)

    fun getAccount(accountId: Int): Account

    fun getAccountList(): LiveData<List<Account>>

}