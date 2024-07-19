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
class EmployeeController(private val service: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<EmployeesDocument> = service.findAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String): EmployeesDocument? = service.findById(id)

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeesDocument): EmployeesDocument = service.save(employee)

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String) = service.deleteById(id)


}
