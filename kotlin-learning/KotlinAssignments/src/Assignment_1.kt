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
    val age: Int = 20;
    ageCheck(age)
    println("Hello, World!")

}

fun ageCheck(age: Int){
    if (age >= 18){
        println("You are an adult")
    }else{
        println("You are a minor")
    }

}
