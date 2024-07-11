
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
package com.dillon.kotlin.assignment7

sealed class Result {
    data class Success(val message: String) : Result()
    data class Error(val message: String) : Result()

}

fun main() {

    val redColor: Color = Color.RED
    val greenColor: Color = Color.GREEN
    val blueColor: Color = Color.BLUE

    val Success: Result = Result.Success("I KNOW WHY")
    val Error: Result = Result.Error("I DO NOT KNOW WHY")


    println("Red color: ${redColor.colorName} has a rgb value of ${redColor.hexCode}")
    println("Green color: ${greenColor.colorName} has a rgb value of ${greenColor.hexCode}")
    println("Blue color: ${blueColor.colorName} has a rgb value of ${blueColor.hexCode}")


    when (Success) {
        is Result.Success -> println("YES")
        is Result.Error -> println("NO")
    }

}