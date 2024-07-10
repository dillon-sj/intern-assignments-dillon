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
    // Create an array of integers
    val multiplesOfFive: Array<Int> = arrayOf(5, 10, 15, 20, 25, 30, 35, 40)

    // Calculate and print the sum of all elements
    val sumOfArray: Int = multiplesOfFive.sum()
    println("The sum of the array is $sumOfArray")

    // Print each number using forEach loop
    for (number in multiplesOfFive) {
        println(number)
    }

    // Find and print the maximum and minimum value
    println("The max number of the array is ${multiplesOfFive.max()}")
    println("The min number of the array is ${multiplesOfFive.min()}")

    // Filter and print only the even numbers
    val evenNumber = multiplesOfFive.filter { it % 2 == 0 }
    println("The even numbers of the array is $evenNumber")

    // Map each element to its square and print the resulting array
    val squared = multiplesOfFive.map { it * it }
    println("The sum of the array is $squared")

    // Check if any element is divisible by 5
    val divisibleBy5 = if (multiplesOfFive.any { it % 5 == 0 }) "Yes" else "No"
    println("Any element of the array divisible by 5?  $divisibleBy5")

    // Sort the array in ascending order and print it
    val sortedArray = multiplesOfFive.sorted()
    println("Sorted array: ${sortedArray.joinToString()}")

    // Reverse the order of elements in the array and print it
    val sortedArrayReverse = multiplesOfFive.sortedByDescending { it }
    println("Reversed array: ${sortedArrayReverse.joinToString()}")

    // Count the number of elements greater than 20 and print the count
    val countGreaterThan20 = multiplesOfFive.filter { it > 20 }
    println("Number of elements greater than 20: ${countGreaterThan20.count()} ")

}