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

    fun existsById(id: String): Boolean = employeeRepository.existsById(id)

    fun save(employee: EmployeesDocument): EmployeesDocument = employeeRepository.save(employee)


//    fun update(id: String, updatedEmployee: EmployeesDocument): EmployeesDocument? {
//        return if (employeeRepository.existsById(id)) {
//            val employeeToUpdate = updatedEmployee.copy(id = id)
//            employeeRepository.save(employeeToUpdate)
//        } else {
//            null
//        }
//    }

    fun update(id: String, updatedEmployee: EmployeesDocument): EmployeesDocument? {
        return if (employeeRepository.existsById(id)) {
            val employeeToUpdate = updatedEmployee.copy(id = id)
            employeeRepository.save(employeeToUpdate)
        } else {
            null
        }
    }

    fun deleteById(id: String) = employeeRepository.deleteById(id)

}

