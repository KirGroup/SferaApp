package com.example.internshipsfera.domain.usecase

import com.example.internshipsfera.domain.Account
import com.example.internshipsfera.domain.AccountListRepository

class AddAccountUseCase(private var accountListRepository: AccountListRepository) {

    fun addAccount(account: Account) {
        accountListRepository.addAccount(account)
    }
}