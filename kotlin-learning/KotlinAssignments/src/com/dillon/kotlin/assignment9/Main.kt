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
package com.dillon.kotlin.assignment9

    fun performOperation(x: Double, y: Double, operation: (Double, Double) -> Double): Double {
        return operation(x, y)
    }

    fun divide(x: Double, y: Double): Double {
        return x / y
    }


fun main() {

    val x = 8.0
    val y = 2.0

    val add: (Double, Double) -> Double = { a, b -> a + b }
    val sub: (Double, Double) -> Double = { a, b -> a - b }
    val multiply: (Double, Double) -> Double = { a, b -> a * b }
    val divides: Double = performOperation(10.0,2.0, ::divide)


    val results = mutableListOf<Double>()
    results.add(performOperation(x, y, add))
    results.add(performOperation(x, y, sub))
    results.add(performOperation(x, y, multiply))
    results.add(divides)

    println("Results:")
    results.forEachIndexed { index, result ->
        println("Operation ${index + 1}: $result")
    }

}
