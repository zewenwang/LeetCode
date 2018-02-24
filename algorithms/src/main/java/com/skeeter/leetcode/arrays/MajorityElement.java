package com.skeeter.leetcode.arrays;

import com.skeeter.leetcode.UtilsKt;

import java.util.Arrays;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * <p>
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author zewenwang created on 2018/2/24.
 */
public class MajorityElement {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                MajorityElement instance = new MajorityElement();
                int[] nums;

//                nums = new int[]{1, 1, 3, 4, 1, 2};
//                System.out.println("nums: " + Arrays.toString(nums)
//                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{6, 5, 5};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

            }
        });
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int major = nums[0];
        int count = 1;
        int maxCount = (nums.length >> 1) + 1;

        for (int i = 1; i < nums.length && count < maxCount; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (major == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return major;
    }

}
