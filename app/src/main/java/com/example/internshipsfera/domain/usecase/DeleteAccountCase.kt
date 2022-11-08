package com.example.internshipsfera.domain.usecase

import com.example.internshipsfera.data.Account
import com.example.internshipsfera.domain.AccountListRepository

class DeleteAccountUseCase(private var accountListRepository: AccountListRepository) {

    fun deleteAccount(account: Account) {
        accountListRepository.deleteAccount(account)
    }
}