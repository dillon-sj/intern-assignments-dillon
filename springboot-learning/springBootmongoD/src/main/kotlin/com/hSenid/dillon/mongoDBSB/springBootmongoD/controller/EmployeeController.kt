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
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getAllEmployees(): ResponseEntity<List<EmployeesDocument>> {
        val employees = employeeService.findAll()
        return if (employees != null) {
            ResponseEntity.ok(employees)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyList<EmployeesDocument>())
        }
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String): ResponseEntity<EmployeesDocument> {
        val employee = employeeService.findById(id)
        return if (employee != null) {
            ResponseEntity.ok(employee)
        } else {
            throw NoSuchElementException("No account found with employee id $id")
        }
    }

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeesDocument): EmployeesDocument = employeeService.save(employee)

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: String, @RequestBody updatedEmployee: EmployeesDocument): EmployeesDocument? {
        return employeeService.update(id, updatedEmployee)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String) = employeeService.deleteById(id)


}
