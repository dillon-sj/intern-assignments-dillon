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
package com.dillon.kotlin.assignment4

class Student(
    name: String, age: Int, private val school: String, private val schoolId: Int
) : Person(name, age) {

    fun printStudentDetails() {
        println("Name: $name, Age: $age, School: $school, SchoolId: $schoolId")
    }

}
