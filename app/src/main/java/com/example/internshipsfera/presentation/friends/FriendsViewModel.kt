package com.example.internshipsfera.presentation.friends

import androidx.lifecycle.ViewModel
import com.example.internshipsfera.data.AccountListRepositoryImpl
import com.example.internshipsfera.data.Account
import com.example.internshipsfera.domain.usecase.AddAccountUseCase
import com.example.internshipsfera.domain.usecase.DeleteAccountUseCase
import com.example.internshipsfera.domain.usecase.EditAccountUseCase
import com.example.internshipsfera.domain.usecase.GetAccountListUseCase

class FriendsViewModel: ViewModel() {

    private val repository = AccountListRepositoryImpl

    private val getAccountUseCase = GetAccountListUseCase(repository)
    private val deleteAccountUseCase = DeleteAccountUseCase(repository)
    private val editAccountUseCase = EditAccountUseCase(repository)
    private val addAccountUseCase = AddAccountUseCase(repository)

    val accountList = getAccountUseCase.getAccountList()

    fun deleteAccount(account: Account) {
        deleteAccountUseCase.deleteAccount(account)
    }

    fun changeEnableState(account: Account) {
        val newItem = account.copy(isSubscribe = !account.isSubscribe)
        editAccountUseCase.editAccount(newItem)
    }

    fun addAccount(account: Account){
        addAccountUseCase.addAccount(account)
    }
}