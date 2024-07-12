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

class Operation {
    fun performOperation(x: Double, y: Double, operation: (Double, Double) -> Double): Double {
        return operation(x, y)
    }

    fun multiply(x: Double, y: Double): Double {
        return x * y
    }
    fun divide(x: Double, y: Double): Double {
        return x / y
    }
}

fun main() {

    val operation = Operation()
    val x = 8.0
    val y = 2.0

    val add: (Double, Double) -> Double = { a, b -> a + b }
    val sub: (Double, Double) -> Double = { a, b -> a - b }
    val multiplies: Double = operation.performOperation(10.0, 2.0, operation::multiply)
    val divides: Double = operation.performOperation(10.0, 2.0, operation::divide)


    val results = mutableListOf<Double>()
    results.add(operation.performOperation(x, y, add))
    results.add(operation.performOperation(x, y, sub))
    results.add(multiplies)
    results.add(divides)

    println("Results:")
    results.forEachIndexed { index, result ->
        println("Operation ${index + 1}: $result")
    }

}
