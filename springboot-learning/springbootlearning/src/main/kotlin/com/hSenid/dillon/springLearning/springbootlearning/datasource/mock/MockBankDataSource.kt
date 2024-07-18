/**
 * Copyright 2008-2019 hSenid Software International (Pvt) Limited.
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Software International (Pvt) Limited.
 *
 * hSenid Software International (Pvt) Limited retains all title
 * to and intellectual property rights in these materials.
 */
package com.hSenid.dillon.springLearning.springbootlearning.datasource.mock

import com.hSenid.dillon.springLearning.springbootlearning.datasource.BankDataSource
import com.hSenid.dillon.springLearning.springbootlearning.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("321", 7.3, 1),
        Bank("123", 5.04, 7),
        Bank("101", 17.38, 6),
        Bank("202", 7.0, 1),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull() {
        it.accountNumber == accountNumber
    } ?: throw NoSuchElementException("No account found with accountNumber $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with accountNumber ${bank.accountNumber} already exists")

        }

        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull() { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("No account found with accountNumber ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("No account found with accountNumber ${accountNumber}")

        banks.remove(currentBank)
    }
}