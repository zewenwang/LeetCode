package com.skeeter.leetcode

import java.util.concurrent.Callable

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

fun runWithTime(runnable: Runnable?): Long {
    return runWithTime { runnable?.run() }
}

fun <T> runWithTime(callable: Callable<T>?): Long {
    return runWithTime { callable?.call() }
}
