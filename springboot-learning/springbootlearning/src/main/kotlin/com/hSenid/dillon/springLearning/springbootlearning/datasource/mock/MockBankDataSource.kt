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
class MockBankDataSource: BankDataSource {

    override fun getBanks(): Collection<Bank> {
        TODO("Not yet implemented")
    }


}