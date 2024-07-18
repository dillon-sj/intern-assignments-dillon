package com.hSenid.dillon.springLearning.springbootlearning.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.hSenid.dillon.springLearning.springbootlearning.model.Bank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    val mockMvc: MockMvc,

    // serialization
    val objectMapper: ObjectMapper,
) {

    val baseURL = "/api/banks"

    @Nested
    @DisplayName("GET /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanks {

        @Test
        fun `should return all banks`() {
            // when/then
            mockMvc.get(baseURL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountNumber") { value("321") }
                }
        }

    }

    @Nested
    @DisplayName("GET /api/banks/{accountNumber}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank {

        @Test
        fun `should return the bank with the given account number`() {
            // given
            val accountNumber = "321"

            // when
            mockMvc.get("$baseURL/$accountNumber")
                .andDo { print() }
                .andExpect { status { isOk() } }
                .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }

            // then
        }

        @Test
        fun `should return NOT FOUND if the account number does not exist`() {
            // given
            val accountNumber = "does_not_exist"

            // when/then
            mockMvc.get("$baseURL/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }
    }

    @Nested
    @DisplayName("POST /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewBank {

        @Test
        fun `should add the new bank`() {
            // given
            val newBank = Bank("acc123", 31.415, 2)

            // when
            val performPost = mockMvc.post(baseURL) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(newBank))
                    }
                }

            mockMvc.get("$baseURL/${newBank.accountNumber}")
                .andExpect { content { json(objectMapper.writeValueAsString(newBank)) } }
        }

        @Test
        fun `should return BAD REQUEST if bank with account number already exists`() {
            // given
            val invalidBank = Bank("321", 7.3, 1)

            // when
            val performPost = mockMvc.post(baseURL) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidBank)
            }

            performPost
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }


    }

    @Nested
    @DisplayName("PATCH /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PatchExisting {

        @Test
        fun `should update an existing bank`() {
            //given
            val updatedBank = Bank("123", 5.04, 7)

            //when
            val performPatchRequest = mockMvc.patch(baseURL) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedBank)
            }

            //then
            performPatchRequest
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(
                            MediaType.APPLICATION_JSON
                        )
                        json(objectMapper.writeValueAsString(updatedBank))
                    }

                }

            mockMvc.get("$baseURL/${updatedBank.accountNumber}")
                .andExpect { content { json(objectMapper.writeValueAsString(updatedBank)) } }


        }

        @Test
        fun `should return BAD REQUEST if no bank with given account number exist`() {
            //given
            val invalidBank = Bank("does_not_exist", 1.0, 1)

            //when
            val performPatchRequest = mockMvc.patch(baseURL) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidBank)

            }

            //then
            performPatchRequest
                .andDo { print() }
                .andExpect { status { isNotFound() } }


        }


    }

    @Nested
    @DisplayName("DELETE /api/banks/{accountNumber}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class DeleteExistingBank {

        @Test
        fun `should delee bank with given account number`() {
            //given
            val accountNumber = "101"


            //when/then
            mockMvc.delete("$baseURL/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isNoContent() }
                }

            mockMvc.get("$baseURL/$accountNumber")
                .andExpect { status { isNotFound() }}



        }
        @Test
        fun `should return NOT FOUND if not bank number account does not exits`() {
            //given
            val invalidAccountNumber = "does_not_exist"
            
            //when
            mockMvc.delete("$baseURL/$invalidAccountNumber")
                .andExpect { status { isNotFound() }   }
            
            //then
            
            
            
        }
        
            
        



    }


}