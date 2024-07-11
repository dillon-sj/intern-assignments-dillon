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
package com.dillon.kotlin.assignment6

object MathUtility {
    fun factorial(n: Int): Long {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
}

fun main() {

    val book = object {

        val title = "The Catcher in the Rye"
        val author = "J.D. Salinger"

    }

    println("Book Title: ${book.title}")
    println("Book Author: ${book.author}")

    val number: Int = 5
    val result = MathUtility.factorial(number)
    println("Factorial of $number is: $result")


}

