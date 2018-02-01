package com.skeeter.leetcode

/**
 *
 * @author  zewenwang created on 02/01/2018.
 */
fun <T> runWithTime(function: () -> T): Long {
    val startTime = System.nanoTime()
    function()
    val costTime = System.nanoTime() - startTime
    println("cost time ${costTime / 1000000.0}ms")
    return costTime
}

