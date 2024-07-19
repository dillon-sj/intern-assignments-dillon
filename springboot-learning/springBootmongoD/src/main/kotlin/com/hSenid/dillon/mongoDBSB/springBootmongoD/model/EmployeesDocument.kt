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
package com.hSenid.dillon.mongoDBSB.springBootmongoD.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "Employees")
data class EmployeesDocument(
    @Id val id: String? = null,
    val employeeId: String?,
    val employeeFirstName: String?,
    val employeeLastName: String?,
    val employeeGender: String?,
    val dob: LocalDate?,
    val designation: String?,
    val employeeAddress: EmployeeAddress?,
    val email: String?,
    val mobileNumber: String?,
    val coe: String?,
    val faction: String?,
    val sbu: List<String>?,
    val joinedDate: LocalDate?,
    val badges: List<EmployeeBadge>?
)

data class EmployeeAddress(
    val building: String?,
    val street: String?,
    val city: String?,
    val district: String?
)

data class EmployeeBadge(
    val project: String?,
    val badge: String?,
    val receivedOn: LocalDate?
)