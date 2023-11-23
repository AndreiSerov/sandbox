package yandexTest

import java.util.*

/**
 * @author andreiserov
 */
/*
4
3
1 2 3

ans: 16
 */


import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    val sorted = nums.sortedDescending()
    var sum = 0

    for (i in 0 until k) {
        sum += sorted[i] * (i + 1)
    }

    println(sum)
}

