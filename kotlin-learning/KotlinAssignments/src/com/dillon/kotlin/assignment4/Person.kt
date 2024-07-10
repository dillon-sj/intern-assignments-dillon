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

//By default, classes cant be inherited so use the open keyword
open class Person(val name: String, val age: Int) {
    open fun printDetails() {
        println("Name: $name, Age: $age")
    }
}