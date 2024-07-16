package com.hSenid.dillon.springLearning.springbootlearning.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()


    @Test
    fun `should provide a collection of banks`() {
        //given

        //when
        val banks = mockDataSource.retrieveBanks()

        //then
        assertThat(banks.size).isGreaterThanOrEqualTo(1)

    }

    @Test
    fun `should provide some mock data`() {
        //given


        //when
        val banks = mockDataSource.retrieveBanks()


        //then
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).allMatch { it.transactionFee != 0 }


    }

    @Test
    fun `should have unique account numbers`() {
        // given

        // when
        val banks = mockDataSource.retrieveBanks()

        // then
        val accountNumbers = banks.map { it.accountNumber }
        val uniqueAccountNumbers = accountNumbers.toSet()

        assertThat(uniqueAccountNumbers.size).isEqualTo(accountNumbers.size)
    }


}