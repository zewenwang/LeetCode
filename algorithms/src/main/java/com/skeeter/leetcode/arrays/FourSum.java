package com.skeeter.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/description/
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * ..[-1,  0, 0, 1],
 * ..[-2, -1, 1, 2],
 * ..[-2,  0, 0, 2]
 * ]
 * <p>
 * [-3,-2,-1,0,0,1,2,3] , 0
 * <p>
 * [
 * [-3,-2,2,3],
 * [-3,-1,1,3],
 * [-3,0,0,3],
 * [-3,0,1,2],
 * [-2,-1,0,3],
 * [-2,-1,1,2],
 * [-2,0,0,2],
 * [-1,0,0,1]
 * ]
 *
 * @author zewenwang created on 2018/2/5.
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum instance = new FourSum();
        int[] nums;
        int target;
        List<List<Integer>> result;

        nums = new int[]{0, 1, 2, 3, -3, -2, -1, 0,};
        target = 0;
        System.out.println("array: " + Arrays.toString(nums) + " , target: " + target);
        System.out.println("result is: \n");
        result = instance.fourSum(nums, target);
        for (List<Integer> list : result) {
            System.out.println(Arrays.asList(list.toArray(new Integer[0])));
        }
        System.out.println();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<List<Integer>>> hashMap = new HashMap<>();
        int sum;
        List<List<Integer>> tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                tmp = hashMap.get(sum);
                if (tmp == null) {
                    tmp = new LinkedList<>();
                }
                tmp.add(Arrays.asList(i, j));
                hashMap.put(sum, tmp);
            }
        }

        int key;
        List<List<Integer>> value, leftValue;
        List<Integer> valueI, leftValueJ;
        HashSet<HashSet<Integer>> resultSet = new HashSet<>();
        HashSet<Integer> tmpSet;
        for (Iterator<Integer> iterator = hashMap.keySet().iterator(); iterator.hasNext(); ) {
            key = iterator.next();
            value = hashMap.get(key);
            leftValue = hashMap.get(target - key);
            if (leftValue == null) {
                continue;
            }
            for (int i = 0; i < value.size(); i++) {
                for (int j = (value == leftValue ? i + 1 : 0); j < leftValue.size(); j++) {
                    valueI = value.get(i);
                    leftValueJ = leftValue.get(j);
                    if (valueI == null || valueI.size() != 2 || leftValueJ == null || leftValueJ.size() != 2
                        || valueI == leftValueJ) {
                        continue;
                    }
                    tmpSet = new HashSet<>(6);
                    tmpSet.add(valueI.get(0));
                    tmpSet.add(valueI.get(1));
                    tmpSet.add(leftValueJ.get(0));
                    tmpSet.add(leftValueJ.get(1));
                    if (tmpSet.size() == 4) {
                        resultSet.add(tmpSet);
                    }
                }
            }

            iterator.remove();
        }

        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> resultElem;
        for (HashSet<Integer> set : resultSet) {
            resultElem = new ArrayList<>(4);
            for (int i : set) {
                resultElem.add(nums[i]);
            }
            result.add(resultElem);
        }
        return new ArrayList<>(result);
    }
}
