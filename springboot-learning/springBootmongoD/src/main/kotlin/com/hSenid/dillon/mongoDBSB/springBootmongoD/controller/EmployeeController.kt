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
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<EmployeesDocument> = employeeService.findAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String): EmployeesDocument? = employeeService.findById(id)

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeesDocument): EmployeesDocument = employeeService.save(employee)

//    @PutMapping("/{id}")
//    fun updateEmployee(@PathVariable id: String, @RequestBody employee: EmployeesDocument): EmployeesDocument? {
//        return employeeService.update(id, employee)
//    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String) = employeeService.deleteById(id)


}
