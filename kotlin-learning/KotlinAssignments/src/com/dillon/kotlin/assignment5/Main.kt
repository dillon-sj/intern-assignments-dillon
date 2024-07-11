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
package com.dillon.kotlin.assignment5

fun main() {
    val shapes: List<Shape> = listOf(

        Circle(5.0),
        Rectangle(5.0, 5.0),
    )

    for (shape in shapes) {
        println("Area: ${shape.area()}")
    }
}
