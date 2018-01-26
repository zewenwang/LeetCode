package com.skeeter.leetcode.arrays

import java.util.*

/**
 *
 * @author  zewenwang created on 2018/1/25.
 */

/**
 * 数组循环右移N步
 * */
object RotateMoveRight {
    /**
     * 从头开始找到其对应的位置
     * 注意：防止循环的产生
     *
     * 最大移动array.size次，
     * */
    fun run(array: Array<Int>, moveRightStep: Int) {
        if (moveRightStep % array.size == 0) {
            return
        }
        var tempSave: Int
        if ((moveRightStep * 2) % array.size == 0) {
            for (i in 0 until moveRightStep) {
                tempSave = array[i]
                array[i] = array[(i + moveRightStep) % array.size]
                array[(i + moveRightStep) % array.size] = tempSave
            }
            return
        }

        var index: Int = 0
        var temp: Int = array[index]
        for (i in 0 until array.size) {
            tempSave = temp
            index = (index + moveRightStep) % array.size
            temp = array[index]
            array[index] = tempSave
        }
    }

    /**
     * 反置整个数组
     * 反置下标 [0,(array.size - moveRightStep)%array.size] 和 [(array.size - moveRightStep)%array.size,array.size-1]数组
     * */
    fun run2(array: Array<Int>, moveRightStep: Int) {
        if (moveRightStep % array.size == 0) {
            return
        }

        swap(array, 0, array.size - 1)
        val part = (array.size - moveRightStep) % array.size
        swap(array, 0, part - 1)
        swap(array, part, array.size - 1)
    }

    fun swap(array: Array<Int>, start: Int, end: Int) {
        if (end <= start + 1 || start < 0 || end >= array.size) {
            return
        }
        val middle = (start + end) / 2
        var temp: Int
        for (i in start..middle) {
            temp = array[i]
            array[i] = array[end - i + start]
            array[end - i + start] = temp
        }
    }
}


fun main(args: Array<String>) {
    val array = arrayOf(1, 3, 5, 6, 7, 8)
    val moveRightSte = 3
    println("old array: ${Arrays.toString(array)}")

//    RotateMoveRight.run(array, moveRightSte)
//    println("new array: ${Arrays.toString(array)}")

//    RotateMoveRight.run2(array, moveRightSte)
//    println("new array: ${Arrays.toString(array)}")

    val result = twoSum(arrayOf(3, 2, 4).toIntArray(), 6)
    println("result : ${Arrays.toString(result)}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val map = mutableMapOf<Int, Int>()
    for (i in 0..nums.size - 1) {
        if (map.contains(target - nums[i])) {
            result[0] = map[target - nums[i]]!!
            result[1] = i
            break
        }
        map.put(nums[i], i)
        println("result : ${map}")
    }
    return result
}
