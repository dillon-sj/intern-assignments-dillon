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
package com.dillon.kotlin.assignment10

import java.util.*

class ScopeFunction {
    var name: String = "Dillon"
    val text: String = "Helloing there"
    var age: Int = 20

    val numberList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

}

fun main() {
    val scopeFunction = ScopeFunction()

    //with scope function  context object this
    //Use on non-null object
    var ageAfterYears: Int = with(scopeFunction) {
        println(this.name)
        println(this.age)
        age + 5 // The last expression is returned from the run block
    }

    println("Dillon will be $ageAfterYears after 5 years")

    //apply scope function  context object this
    //to initialise or configure an object
    val scopeFunction2 = ScopeFunction().apply {
        name = "Vanuja"
        age = 21
    }

    println(scopeFunction2.name)
    println(scopeFunction2.age)

    //also scope function  context object it
    //to do additional configuration
    scopeFunction.numberList.also {

        println("Contents of the number list $it")
        it.add(6)
        println("Contents of the number list after adding 6 $it")
        it.remove(1)
        println("Contents of the number list after adding 1 $it")


    }

    scopeFunction2.also {
        it.name = "Steph"
        println("New name${it.name}")
    }

    /**
     * run scope function  context object this
     * use to operate on nullable object, execute lambda expression
     * and avid NullPointerException
     * combo of with and let
     */
    val result = scopeFunction.text.run {
        val upperCaseText = this.uppercase(Locale.getDefault())
        println("Uppercase Text: $upperCaseText")
        println("Length of the string: ${this.length}")
        upperCaseText // The last expression is returned from the run block
    }
    println("Result returned by run: $result")
}
