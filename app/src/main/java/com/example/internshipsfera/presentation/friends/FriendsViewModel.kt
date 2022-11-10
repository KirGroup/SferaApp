package com.example.internshipsfera.presentation.friends

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
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
    private val editAccountUseCase = EditAccountUseCase(repository)

    val allAccountList = getAccountUseCase.getAccountList()

    val filteredAccountList: MutableLiveData<List<Account>> = MediatorLiveData().apply{  }//во вех фрагментах

    fun changeEnableState(account: Account) {
        val newItem = account.copy(isSubscribe = !account.isSubscribe)
        editAccountUseCase.editAccount(newItem)
    }
}