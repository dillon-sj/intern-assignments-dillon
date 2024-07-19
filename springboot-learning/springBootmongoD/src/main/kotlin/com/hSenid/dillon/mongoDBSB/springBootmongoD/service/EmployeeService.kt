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
package com.hSenid.dillon.mongoDBSB.springBootmongoD.service

import com.hSenid.dillon.mongoDBSB.springBootmongoD.model.EmployeesDocument
import com.hSenid.dillon.mongoDBSB.springBootmongoD.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val repository: EmployeeRepository) {

    fun findAll(): List<EmployeesDocument> = repository.findAll()

    fun findById(id: String): EmployeesDocument? = repository.findById(id).orElse(null)

    fun save(employee: EmployeesDocument): EmployeesDocument = repository.save(employee)

    fun deleteById(id: String) = repository.deleteById(id)

}
