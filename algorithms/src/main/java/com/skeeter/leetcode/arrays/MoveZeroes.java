package com.skeeter.leetcode.arrays;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author zewenwang created on 02/04/2018.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes instance = new MoveZeroes();
        int[] nums;

        nums = new int[]{0, 1, 0, 3, 12};
        System.out.println("old array: " + Arrays.toString(nums));
        instance.moveZeroes(nums);
        System.out.println("new array: " + Arrays.toString(nums) + "\n");

        nums = new int[]{0, 1, 0, 3, 0, 0, 12};
        System.out.println("old array: " + Arrays.toString(nums));
        instance.moveZeroes(nums);
        System.out.println("new array: " + Arrays.toString(nums) + "\n");

        nums = new int[]{1, 0, 3, 0, 0, 12};
        System.out.println("old array: " + Arrays.toString(nums));
        instance.moveZeroes(nums);
        System.out.println("new array: " + Arrays.toString(nums) + "\n");

    }

    public void moveZeroes(int[] nums) {
        moveZeroes1(nums);
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zeroMin = -1;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroMin < 0) {
                    zeroMin = i;
                }
            } else {
                if (zeroMin >= 0) {
                    tmp = nums[zeroMin];
                    nums[zeroMin] = nums[i];
                    nums[i] = tmp;
                    zeroMin++;
                }
            }
        }
    }
}
