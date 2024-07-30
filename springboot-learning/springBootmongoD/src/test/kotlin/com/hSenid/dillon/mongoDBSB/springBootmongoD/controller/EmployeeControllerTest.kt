package com.hSenid.dillon.mongoDBSB.springBootmongoD.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeeAddress
import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeesDocument
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class EmployeeControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper,


    ) {

    val baseUrl = "/api/employees"


    @Nested
    @DisplayName("GET /api/employees")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEmployees {
        @Test
        fun `should return all employees`() {
            //when
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].id") { value("5e4d604991b6134a75045ecd") }

                }
        }


    }

    @Nested
    @DisplayName("GET /api/employees/{id}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEmployeeById {

        @Test
        fun `should return the employee with the given employee id`() {
            // given
            val employeeId = "5e4d604991b6134a75045ecd"

            // when
            mockMvc.get("$baseUrl/$employeeId")
                .andDo { print() }
                .andExpect { status { isOk() } }
                .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }

            // then
        }

        @Test
        fun `should return NOT FOUND if the  employee id does not exist`() {
            // given
            val employeeId = "does_not_exist"

            // when/then
            mockMvc.get("$baseUrl/$employeeId")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }
    }


    @Nested
    @DisplayName("POST /api/employees")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewBank {

        @Test
        fun `should add the new employee`() {
            // given
            val uniqueId = UUID.randomUUID().toString()
            val newEmployee = EmployeesDocument(
                id = uniqueId,
                employee_id = "001001",
                employee_first_name = "Chirantha",
                employee_last_name = "Pitigala",
                employee_gender = "male",
                dob = "",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10",
                    street = "Perera Avenue",
                    city = "Nugegoda",
                    district = "Colombo"
                ),
                email = "chirantha@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )

            // when
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newEmployee)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(newEmployee))
                    }
                }

            mockMvc.get("$baseUrl/${newEmployee.id}")
                .andExpect { content { json(objectMapper.writeValueAsString(newEmployee)) } }
        }

        @Test
        fun `should return a BAD REQUEST when ID already exists`() {
            //given
            val existingEmployee = EmployeesDocument(
                id = "5e4d604991b6134a75045ecd",
                employee_id = "001001",
                employee_first_name = "Chirantha",
                employee_last_name = "Pitigala",
                employee_gender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10",
                    street = "Perera Avenue",
                    city = "Nugegoda",
                    district = "Colombo"
                ),
                email = "chirantha@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )


            // when
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(existingEmployee)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isConflict() }
                }


        }


    }
    
    
    @Nested
    @DisplayName("PUT /api/employees/{id}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PutUpdateEmployee {
        
        @Test
        fun `should update the employee`() {
            //given
            val existingId = "5e4d604991b6134a75045ecd"
            val existingEmployee = EmployeesDocument(
                id = existingId,
                employee_id = "001001",
                employee_first_name = "Chirantha",
                employee_last_name = "Pitigala",
                employee_gender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10",
                    street = "Perera Avenue",
                    city = "Nugegoda",
                    district = "Colombo"
                ),
                email = "chirantha@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )

            val updatedEmployee = EmployeesDocument(
                id = existingId,
                employee_id = "001007",
                employee_first_name = "Vanuja",
                employee_last_name = "Pitigala",
                employee_gender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10",
                    street = "Perera Avenue",
                    city = "Nugegoda",
                    district = "Colombo"
                ),
                email = "chirantha@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )

            //when
            val performPut = mockMvc.put("/api/employees/$existingId") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedEmployee)
            }
            
            //then
            // then
            performPut
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updatedEmployee))
                    }
                }
            
            
        }
        
            
        
    
    }

    @Nested
    @DisplayName("DELETE /api/employees/{id}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class DeleteExistingEmployee {

        @Test
        fun `should delete employee with given employee number`() {
            //given
            val employeeId = "5e4d608291b6134a75045ecf"


            //when/then
            mockMvc.delete("$baseUrl/$employeeId")
                .andDo { print() }
                .andExpect {
                    status { isNoContent() }
                }

            mockMvc.get("$baseUrl/$employeeId")
                .andExpect { status { isNotFound() } }


        }

    }
}