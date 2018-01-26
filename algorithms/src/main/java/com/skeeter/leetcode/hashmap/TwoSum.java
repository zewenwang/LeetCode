package com.skeeter.leetcode.hashmap;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * <p/>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p/>
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 *
 * @author michael created on 16/2/23.
 */
public class TwoSum {

    public int[] function(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] functionBase(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[1] = j;
                    break;
                }
            }
            if (result[1] != 0) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum exmple = new TwoSum();
        int[] result = exmple.function(new int[]{3,2,4}, 6);
        for (int i : result) {
            System.out.println("index = [" + i + "]");
        }

    }
}
