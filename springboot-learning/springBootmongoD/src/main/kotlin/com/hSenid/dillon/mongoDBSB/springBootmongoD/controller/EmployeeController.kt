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
        logger.error("Not Found: ${e.message}")
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }


    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> {
        logger.error("Bad Request: ${e.message}")
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalStateException::class)
    fun handleConflict(e: IllegalStateException): ResponseEntity<String> {
        logger.error("Conflict: ${e.message}")
        return ResponseEntity(e.message, HttpStatus.CONFLICT)
    }

    private fun logAndThrow(exception: Exception): Nothing {
        logger.error(exception.message)
        throw exception
    }

    @GetMapping
    fun getAllEmployees(): ResponseEntity<List<EmployeesDocument>> {
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
        val employee = employeeService.findByEmployeeId(employeeId)
        return if (employee != null) {
            logger.info("Successfully fetched employee with id $employeeId")
            ResponseEntity.ok(employee)
        } else {
            logAndThrow(NoSuchElementException("${HttpStatus.NOT_FOUND}\nNo Employee found with id $employeeId"))
        }
    }

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeesDocument): ResponseEntity<EmployeesDocument> {
        if (employeeService.findByEmployeeId(employee.employeeId) != null) {
            logAndThrow(IllegalStateException("An employee with ID ${employee.employeeId} already exists."))
        }
        val savedEmployee = employeeService.save(employee)
        logger.info("Successfully created employee with id ${employee.employeeId}")
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
            logger.info("Successfully updated employee with id $id")
            ResponseEntity.ok(updated)
        } else {
            logAndThrow(NoSuchElementException("No Employee found with id $id"))
        }
    }


    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String): ResponseEntity<Void> {
        return if (employeeService.findById(id) != null) {
            employeeService.deleteById(id)
            logger.info("Successfully deleted employee with id $id")
            ResponseEntity.noContent().build()
        } else {
            logAndThrow(NoSuchElementException("${HttpStatus.NOT_FOUND}\nNo Employee found with id $id"))
        }
    }
}
