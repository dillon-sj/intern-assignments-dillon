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

class Main {
    fun performOperation(x: Double, y: Double, operation: (Double, Double) -> Double): Double {
        return operation(x, y)
    }

}

fun main() {
    val main = Main()
    val x = 8.0
    val y = 2.0

    val add: (Double, Double) -> Double = { a, b -> a + b }
    val sub: (Double, Double) -> Double = { a, b -> a - b }
    val multiply: (Double, Double) -> Double = { a, b -> a * b }
    val divide: (Double, Double) -> Double = { a, b -> a / b }

    val results = mutableListOf<Double>()
    results.add(main.performOperation(x, y, add))
    results.add(main.performOperation(x, y, sub))
    results.add(main.performOperation(x, y, multiply))
    results.add(main.performOperation(x, y, divide))

    println("Results:")
    results.forEachIndexed { index, result ->
        println("Operation ${index + 1}: $result")
    }

}
