package com.example.internshipsfera.domain.usecase

import com.example.internshipsfera.data.Account
import com.example.internshipsfera.domain.AccountListRepository

class GetAccountUseCase(private var accountListRepository: AccountListRepository) {

    fun getAccount(accountId: Int): Account {
        return accountListRepository.getAccount(accountId)
    }
}