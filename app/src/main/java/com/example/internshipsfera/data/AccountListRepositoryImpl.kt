package com.example.internshipsfera.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.internshipsfera.domain.Account
import com.example.internshipsfera.domain.AccountListRepository

object AccountListRepositoryImpl: AccountListRepository {

    private val accountListLD = MutableLiveData<List<Account>>()
    private val accountList = sortedSetOf<Account>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementedId = 0

    init {
        for (i in 0 until 40){
            val item = Account("Name $i", "ds", false, i)
            addAccount(item)
        }
    }

    override fun addAccount(account: Account) {
        if(account.id == Account.UNDEFINED_ID) account.id = autoIncrementedId++
        accountList.add(account)
        updateList()
    }

    override fun deleteAccount(account: Account) {
        accountList.remove(account)
        updateList()
    }

    override fun editAccount(account: Account) {
        accountList.remove(getAccount(account.id))
        accountList.add(account)
    }

    override fun getAccount(accountId: Int): Account {
        return accountList.find{ it.id ==  accountId} ?: throw RuntimeException("Element with id:$accountId not found")
    }

    override fun getAccountList(): LiveData<List<Account>> {
        return accountListLD
    }

    private fun updateList() {
        accountListLD.value = accountList.toList()
    }
}