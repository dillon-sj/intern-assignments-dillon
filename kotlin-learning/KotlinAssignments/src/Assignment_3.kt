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
    val multiplesOfFive: Array<Int> = arrayOf(5, 10, 15, 20, 25, 30, 35, 40)
    val sumOfArray: Int = multiplesOfFive.sum()
    println("The sum of the array is $sumOfArray")

    for (number in multiplesOfFive) {
        println(number)
    }


}