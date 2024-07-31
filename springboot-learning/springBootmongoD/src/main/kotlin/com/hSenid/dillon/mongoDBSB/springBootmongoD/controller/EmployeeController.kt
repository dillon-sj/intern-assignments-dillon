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
package com.hSenid.dillon.mongoDBSB.springBootmongoD.controller

import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeesDocument
import com.hSenid.dillon.mongoDBSB.springBootmongoD.service.EmployeeService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    private val logger = LoggerFactory.getLogger(EmployeeController::class.java)

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> {
        logger.error("Not Found: ${e.message}\nStacktrace: ${e.stackTrace.joinToString("\n")}", e)
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> {
        logger.error("Bad Request: ${e.message}\nStacktrace: ${e.stackTrace.joinToString("\n")}", e)
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalStateException::class)
    fun handleConflict(e: IllegalStateException): ResponseEntity<String> {
        logger.error("Conflict: ${e.message}\nStacktrace: ${e.stackTrace.joinToString("\n")}", e)
        return ResponseEntity(e.message, HttpStatus.CONFLICT)
    }

    private fun logAndThrow(exception: Exception): Nothing {
        logger.error("Exception occurred: ${exception.message}\nStacktrace: ${exception.stackTrace.joinToString("\n")}", exception)
        throw exception
    }

    @GetMapping
    fun getAllEmployees(): ResponseEntity<List<EmployeesDocument>> {
        logger.info("Get all employees")
        val employees = employeeService.findAllEmployee()
        return if (employees != null) {
            logger.info("Successfully fetched all employees")
            ResponseEntity.ok(employees)
        } else {
            logAndThrow(NoSuchElementException("${HttpStatus.NOT_FOUND}\nNo employees found"))
        }
    }

    @GetMapping("/{employeeId}")
    fun getByEmployeeId(@PathVariable employeeId: String): ResponseEntity<EmployeesDocument> {
        logger.info("Fetching employee by employeeId: $employeeId")
        val employee = employeeService.findByEmployeeId(employeeId)
        return if (employee != null) {
            logger.info("Successfully fetched employee id - [{}]", employeeId)
            ResponseEntity.ok(employee)
        } else {
            logAndThrow(NoSuchElementException("${HttpStatus.NOT_FOUND}\nNo Employee found with id $employeeId"))
        }
    }

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeesDocument): ResponseEntity<EmployeesDocument> {
        logger.info("Creating new employee")
        if (employeeService.findByEmployeeId(employee.employeeId) != null) {
            logAndThrow(IllegalStateException("An employee with ID ${employee.employeeId} already exists."))
        }
        val savedEmployee = employeeService.save(employee)
        logger.info("Successfully created employee id - [{}]", employee.employeeId)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee)
    }

    @PutMapping("/{id}")
    fun updateEmployee(
        @PathVariable id: String,
        @RequestBody updatedEmployee: EmployeesDocument,
    ): ResponseEntity<EmployeesDocument> {
        if (id.isEmpty()) {
            logAndThrow(IllegalArgumentException("Employee ID must be provided"))
        }

        val updated = employeeService.update(id, updatedEmployee)
        return if (updated != null) {
            logger.info("Successfully updated employee id - [{}]", id)
            ResponseEntity.ok(updated)
        } else {
            logAndThrow(NoSuchElementException("No Employee found with id $id"))
        }
    }


    @DeleteMapping("/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: String): ResponseEntity<Any> {
        logger.info("Deleting employee: $employeeId")
        val employee = employeeService.findByEmployeeId(employeeId)
        return if (employee != null) {
            try {
                employeeService.deleteByEmployeeId(employeeId)
                logger.info("Successfully deleted employee with id $employeeId")
                ResponseEntity.ok("Successfully deleted employee with id $employeeId")
            } catch (e: Exception) {
                logger.error("Error deleting employee id - [{}]: ${e.message}", employeeId, e)
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            }
        } else {
            logAndThrow(NoSuchElementException("${HttpStatus.NOT_FOUND}\nNo Employee found with id $employeeId"))
        }
    }
}
