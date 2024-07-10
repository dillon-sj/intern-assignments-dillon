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


fun sayHello() {
    println("Hello World")
}

fun sayHelloing(itemToGreet: String) {
    println("Helloing $itemToGreet")

}


fun main() {
    println("Hello Kotlin");
    sayHello();
    sayHelloing("Kotlin");
}