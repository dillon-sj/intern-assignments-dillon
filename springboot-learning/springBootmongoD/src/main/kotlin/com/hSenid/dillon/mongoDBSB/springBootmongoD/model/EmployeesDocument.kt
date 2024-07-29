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
    val employee_id: String = "UNKNOWN_ID",
    val employee_first_name: String = "Unknown",
    val employee_last_name: String = "Unknown",
    val employee_gender: String = "Unknown",
    val dob: LocalDate = LocalDate.now(),
    val designation: String = "Employee",
    val employee_address: EmployeeAddress = EmployeeAddress(),
    val email: String = "unknown@example.com",
    val mobile_number: String = "000-000-0000",
    val coe: String = "Unknown",
    val faction: String = "Unknown",
    val sbu: List<String> = emptyList(),
    val joined_date: LocalDate = LocalDate.now(),
    val badges: List<EmployeeBadge> = emptyList(),
)

data class EmployeeAddress(
    val building: String = "Unknown Building",
    val street: String = "Unknown Street",
    val city: String = "Unknown City",
    val district: String = "Unknown District",
)

data class EmployeeBadge(
    val project: String = "Unknown Project",
    val badge: String = "No Badge",
    val received_on: LocalDate = LocalDate.now(),
)