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

open class Person(name: String, var age: Int) {
    var name: String? = name

    open fun printDetails() {
        println("Name: $name, Age: $age")

    }

    override fun toString(): String {
        return "Person(age=$age, name=$name)"
    }

}