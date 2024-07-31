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
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun findAllEmployee(): List<EmployeesDocument> = employeeRepository.findAll()

    fun findById(id: String): EmployeesDocument? = employeeRepository.findById(id).orElse(null)

    fun findByEmployeeId(employeeId: String): EmployeesDocument? = employeeRepository.findByEmployeeId(employeeId)

    fun existsById(employeeId: String): Boolean = employeeRepository.existsById(employeeId)

    fun save(employee: EmployeesDocument): EmployeesDocument = employeeRepository.save(employee)

    fun update(employeeId: String, updatedEmployee: EmployeesDocument): EmployeesDocument? {
        return if (employeeRepository.existsById(employeeId)) {
            val employeeToUpdate = updatedEmployee.copy(employeeId = employeeId)
            employeeRepository.save(employeeToUpdate)
        } else {
            null
        }
    }

    fun deleteById(id: String) = employeeRepository.deleteById(id)


}

