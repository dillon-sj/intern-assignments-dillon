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

    fun findAll(): List<EmployeesDocument> = employeeRepository.findAll()

    fun findById(employee_id: String): EmployeesDocument? = employeeRepository.findById(employee_id).orElse(null)

    fun save(employee: EmployeesDocument): EmployeesDocument = employeeRepository.save(employee)

    fun update(id: String, updatedEmployee: EmployeesDocument): EmployeesDocument? {
        return if (employeeRepository.existsById(id)) {
            val employeeToUpdate = updatedEmployee.copy(id = id) // Ensure the ID is preserved
            employeeRepository.save(employeeToUpdate)
        } else {
            null
        }
    }

    fun deleteById(id: String) = employeeRepository.deleteById(id)

}
