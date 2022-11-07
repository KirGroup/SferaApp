package com.example.internshipsfera.domain.usecase

import androidx.lifecycle.LiveData
import com.example.internshipsfera.domain.Account
import com.example.internshipsfera.domain.AccountListRepository

class GetAccountListUseCase(private var accountListRepository: AccountListRepository) {

    fun getAccountList(): LiveData<List<Account>> {
        return accountListRepository.getAccountList()
    }
}