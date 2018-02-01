package com.skeeter.leetcode.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/single-number/description/">136. Single Number</a>
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * 按位异或的规律：1. x ^ x = 0 ; 2. 0 ^ x = x ; 3. -1 ^ x = ~x
 * <p>
 * *
 *
 * @author zewenwang created on 2018/1/29.
 */
public class SingleNumber {

    public static void main(String[] args) {

        System.out.println("" + (3 ^ 3));
        System.out.println("" + (3 ^ -3));
        System.out.println("" + (5 ^ -1));
        System.out.println("" + (3 ^ 0));

        SingleNumber instance = new SingleNumber();
        int[] nums1 = new int[]{2, 2, 1};
        System.out.println("array: " + Arrays.toString(nums1) + " , result: " + instance.singleNumber(nums1));

        int[] nums2 = new int[]{2, 1, 2, 3, 3};
        System.out.println("array: " + Arrays.toString(nums2) + " , result: " + instance.singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        return singleNumber2(nums);
    }

    /**
     * 按位异或的规律：1. x ^ x = 0 ; 2. 0 ^ x = x ; 3. -1 ^ x = ~x
     */
    public int singleNumber2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public int singleNumber1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> hashSet = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }

        return hashSet.toArray(new Integer[1])[0];
    }


}
