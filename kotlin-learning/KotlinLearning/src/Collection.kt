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
    val interestingThings = arrayOf("Kotlin", "Java", "Python", "C++", "JavaScript")
    println(interestingThings)
    println(interestingThings[0])
    println(interestingThings.get(1))

    for (item in interestingThings) {
        println(item)
    }

    interestingThings.forEach { interestingThing ->
        println(interestingThing)

    }

    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at this index $index")

    }


}