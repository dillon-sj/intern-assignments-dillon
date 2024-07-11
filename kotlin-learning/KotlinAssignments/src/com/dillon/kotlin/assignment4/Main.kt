package com.dillon.kotlin.assignment4


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
fun main() {

    val person = Person("Dillon", 20)
    val student = Student("Dillon", 20, "schoolName", 2024)

    person.printDetails()

    student.printDetails()
    student.printStudentDetails()

}