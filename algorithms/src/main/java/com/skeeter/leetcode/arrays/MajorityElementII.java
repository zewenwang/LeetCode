package com.skeeter.leetcode.arrays;

import com.skeeter.leetcode.UtilsKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II
 * https://leetcode.com/problems/majority-element-ii/description/
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 *
 * @author zewenwang created on 2018/2/25.
 */
public class MajorityElementII {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                MajorityElementII instance = new MajorityElementII();
                int[] nums;

                nums = new int[]{1, 2, 2, 3, 2, 1, 1, 3};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{1};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{1, 2};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{1, 2, 3};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{3, 2, 3};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

                nums = new int[]{2, 2, 1, 3, 4};
                System.out.println("nums: " + Arrays.toString(nums)
                    + " , majorityElement: " + instance.majorityElement(nums));

            }
        });
    }


    /**
     * more than n/3, so elements.length <= 2
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList = new ArrayList<>(2);
        if (nums == null || nums.length <= 0) {
            return resultList;
        }

        Integer majorA = null, majorB = null;
        int countA = 0, countB = 0;

        for (int num : nums) {
            if (majorA != null && majorA == num) {
                countA++;
            } else if (majorB != null && majorB == num) {
                countB++;
            } else if (countA == 0) {
                majorA = num;
                countA++;
            } else if (countB == 0) {
                majorB = num;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }

        // 获得实际的count
        countA = countB = 0;
        for (int num : nums) {
            if (majorA != null && num == majorA) {
                countA++;
            } else if (majorB != null && majorB == num) {
                countB++;
            }
        }

        if (countA > nums.length / 3 && majorA != null) {
            resultList.add(majorA);
        }
        if (countB > nums.length / 3 && majorB != null) {
            resultList.add(majorB);
        }
        return resultList;
    }

}
