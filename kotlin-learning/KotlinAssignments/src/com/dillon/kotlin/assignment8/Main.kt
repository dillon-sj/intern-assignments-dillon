package com.dillon.kotlin.assignment8

import com.dillon.kotlin.assignment8.Main.Person
import java.time.Year

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

class Main {
    data class Person(val name: String, val age: Int)


}

fun Person.birthYearCalc(): Int {
    return (Year.now().value) - this.age

}

fun main() {

    val person = listOf(Person("Alice", 29),Person("Bob", 31),
                        Person("Dillon",20), Person("Charlie", 35),
                        Person("Diana", 40))

    for (p in person) {
        println("${p.name} was born in the year ${p.birthYearCalc()}")
    }


}

