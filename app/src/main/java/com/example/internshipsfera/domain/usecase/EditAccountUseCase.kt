package com.example.internshipsfera.domain.usecase

import com.example.internshipsfera.data.Account
import com.example.internshipsfera.domain.AccountListRepository

class EditAccountUseCase(private var accountListRepository: AccountListRepository) {

    fun editAccount(account: Account) {
        accountListRepository.editAccount(account)
    }
}