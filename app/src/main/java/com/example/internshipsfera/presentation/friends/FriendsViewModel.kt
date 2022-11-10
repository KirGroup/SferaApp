package com.example.internshipsfera.presentation.friends

import androidx.lifecycle.*
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

    val filteredAccountList: MediatorLiveData<List<Account>>  = MediatorLiveData<List<Account>>()

    fun getFilteredAccountList(): LiveData<List<Account>> {
         filteredAccountList.addSource(allAccountList, Observer {
            filteredAccountList.value = it
        })
        return filteredAccountList
    }

    fun changeEnableState(account: Account) {
        val newItem = account.copy(isSubscribe = !account.isSubscribe)
        editAccountUseCase.editAccount(newItem)
    }
}