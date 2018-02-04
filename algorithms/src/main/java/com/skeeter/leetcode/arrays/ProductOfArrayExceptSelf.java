package com.skeeter.leetcode.arrays;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * <p>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 *
 * @author zewenwang created on 02/04/2018.
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf instance = new ProductOfArrayExceptSelf();
        int[] nums;

        nums = new int[]{1, 2, 3, 4};
        System.out.println("old array: " + Arrays.toString(nums)
            + "\nnew array: " + Arrays.toString(instance.productExceptSelf(nums)) + "\n");

        nums = new int[]{0, 2, 3, 4};
        System.out.println("old array: " + Arrays.toString(nums)
            + "\nnew array: " + Arrays.toString(instance.productExceptSelf(nums)) + "\n");

        nums = new int[]{0, 2, 0, 4};
        System.out.println("old array: " + Arrays.toString(nums)
            + "\nnew array: " + Arrays.toString(instance.productExceptSelf(nums)) + "\n");

    }

    public int[] productExceptSelf(int[] nums) {
        return productExceptSelfWithoutDivision(nums);
    }

    /**
     * 不带有除的解法
     * <p>
     * 1. 先计算不带自己的临时结果
     * 2. 反向累计和不带自己的结果计算出最终的结果
     */
    public int[] productExceptSelfWithoutDivision(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    /**
     * 带有除的解法
     */
    public int[] productExceptSelfWithDivision(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int totalProduct = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                nums[i] = 0;
            } else if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = totalProduct;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = totalProduct / nums[i];
            }
        }
        return nums;
    }

}
