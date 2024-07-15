package com.hSenid.dillon.springLearning.springbootlearning.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.testng.asserts.Assertion

internal class  MockBankDataSourceTest{

    private val mockDataSource = MockBankDataSource()


    @Test
    fun `should provide a collection of banks`() {
        //given

        //when
        val banks = mockDataSource.getBanks()

        //then
        Assertions.assertThat(banks).isNotEmpty()

    }


}