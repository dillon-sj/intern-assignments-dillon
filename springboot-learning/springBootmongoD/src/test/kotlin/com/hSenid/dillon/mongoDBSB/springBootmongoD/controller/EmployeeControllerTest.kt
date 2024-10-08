package com.hSenid.dillon.mongoDBSB.springBootmongoD.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeeAddress
import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeesDocument
import com.hSenid.dillon.mongoDBSB.springBootmongoD.service.EmployeeService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*
import java.util.*


@SpringBootTest
@AutoConfigureMockMvc
internal class EmployeeControllerTest @Autowired constructor(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper,
    @Autowired val employeeService: EmployeeService,

    ) {

    val baseUrl = "/api/employees"

    @Nested
    @DisplayName("GET /api/employees")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEmployees {
        @Test
        fun `should return all employees`() {
            //given
            val employeeById = "001003"
            //when
            mockMvc.get(baseUrl).andDo { print() }.andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].employeeId") { value(employeeById) }

            }
        }

    }

    @Nested
    @DisplayName("GET /api/employees/{employeed}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEmployeeById {

        @Test
        fun `should return the employee with the given employee id`() {
            // given
            val employeeId = "001003"

            // when
            mockMvc.get("$baseUrl/$employeeId").andDo { print() }.andExpect { status { isOk() } }
                .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }

            // then
        }

        @Test
        fun `should return NOT FOUND if the  employee id does not exist`() {
            // given
            val employeeId = "does_not_exist"

            // when/then
            mockMvc.get("$baseUrl/$employeeId").andDo { print() }.andExpect { status { isNotFound() } }
        }
    }


    @Nested
    @DisplayName("POST /api/employees")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewEmployee {
        private val uniqueId = UUID.randomUUID().toString()

        @Test
        fun `should add the new employee`() {
            // given
            val newEmployee = EmployeesDocument(
                _id = "",
                employeeId = uniqueId,
                employeeFirstName = "Chirantha",
                employeeLastName = "Pitigala",
                employeeGender = "male",
                dob = "",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10", street = "Perera Avenue", city = "Nugegoda", district = "Colombo"
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
            performPost.andDo { print() }.andExpect {
                status { isCreated() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(newEmployee))
                }
            }

            mockMvc.get("$baseUrl/${newEmployee.employeeId}")
                .andExpect { content { json(objectMapper.writeValueAsString(newEmployee)) } }
        }

        @Test
        fun `should return a BAD REQUEST when ID already exists`() {
            //given
            val existingEmployee = EmployeesDocument(
                _id = "5e4d604991b6134a75045ecd",
                employeeId = "001001",
                employeeFirstName = "Chirantha",
                employeeLastName = "Pitigala",
                employeeGender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10", street = "Perera Avenue", city = "Nugegoda", district = "Colombo"
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
            performPost.andDo { print() }.andExpect {
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
            val existingId = "13212321"
            val existingEmployee = EmployeesDocument(
                _id = "",
                employeeId = existingId,
                employeeFirstName = "Chirantha",
                employeeLastName = "Pitigala",
                employeeGender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10", street = "Perera Avenue", city = "Nugegoda", district = "Colombo"
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
                content = objectMapper.writeValueAsString(existingEmployee)
            }

            //then
            performPut.andDo { print() }.andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(existingEmployee))
                }
            }

        }

        @Test
        fun `should return NOT FOUND if the employee id does not exist`() {
            //given
            val nonExistentId = "non-existent-id"
            val updatedEmployee = EmployeesDocument(
                _id = "",
                employeeId = nonExistentId,
                employeeFirstName = "Vanuja",
                employeeLastName = "Pitigala",
                employeeGender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10", street = "Perera Avenue", city = "Nugegoda", district = "Colombo"
                ),
                email = "chirantha@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )

            //when/then
            mockMvc.put("/api/employees/$nonExistentId") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatedEmployee)
            }.andDo { print() }.andExpect {
                status { isNotFound() }
            }
        }

    }

    @Nested
    @DisplayName("DELETE /api/employees/{employeeId}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class DeleteExistingEmployee {

        private val employeeId = "to-be-deleted"
        private val nonExistentId = "non-existent-id"

        @BeforeEach
        fun setup() {
            mockMvc.delete("$baseUrl/$employeeId").andExpect {
                status { isNoContent() }
            }

            val employeeToDelete = EmployeesDocument(
                _id = "",
                employeeId = employeeId,
                employeeFirstName = "Vanuja",
                employeeLastName = "Pitigala",
                employeeGender = "male",
                dob = "1985-03-03",
                designation = "Deputy General Manager",
                employee_address = EmployeeAddress(
                    building = "No. 10", street = "Perera Avenue", city = "Nugegoda", district = "Colombo"
                ),
                email = "vanuja@hsenidmobile.com",
                mobile_number = "+94717877672",
                coe = "Implementation",
                faction = "YAKSHA",
                sbu = listOf("SYSTEM IMPLEMENTATION"),
                joined_date = "2008-03-03",
                badges = emptyList()
            )
            mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(employeeToDelete)
            }.andExpect {
                status { isCreated() }
            }
        }

        @Test
        fun `should delete employee with given employee number`() {
            // when/then
            mockMvc.delete("$baseUrl/$employeeId").andDo { print() }.andExpect {
                status { isNoContent() }
            }

            mockMvc.get("$baseUrl/$employeeId").andExpect { status { isNotFound() } }
        }

        @Test
        fun `should return NOT FOUND if the employee id does not exist`() {
            // when/then
            mockMvc.delete("$baseUrl/$nonExistentId").andDo { print() }.andExpect {
                status { isNotFound() }
            }
        }
    }
}