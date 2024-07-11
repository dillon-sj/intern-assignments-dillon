package com.dillon.kotlin.assignment7


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

enum class Color(var colorName: String, var hexCode: String) {
    RED("red", "ff0000"),
    GREEN("green", "00ff00"),
    BLUE("blue", "0000ff"),
    WHITE("white", "ffffff"),
    BLACK("black", "000000"),


}

fun main() {
    Color.entries.forEach { println(it)}
}