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

val name: String = "Dillon"
var day: String? = null

fun main() {
    var greeting: String = "Hello, $name!"
    val greetingPrint = if (day != null) "Hello, $name!" else "Helloing there Stranger"
    val greetingToPrint = when (true) {
        null -> "Hello, $name!"
        else -> "Why Helloing there again??"
    }

    println(name)
    println(greetingPrint)
    println(greetingToPrint)

}

