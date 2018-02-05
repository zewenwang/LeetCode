package com.skeeter.leetcode.map;

import com.skeeter.leetcode.UtilsKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author zewenwang created on 02/04/2018.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                TopKFrequentElements instance = new TopKFrequentElements();
                int[] nums;
                int k;

                nums = new int[]{1, 1, 1, 2, 2, 3};
                k = 2;
                System.out.println(String.format("top %s frequent of %s is %s", k, Arrays.toString(nums),
                    Arrays.toString(instance.topKFrequent(nums, k).toArray(new Integer[0]))));

                nums = new int[]{1, 1, 1, 2, 2, 3, 3};
                k = 2;
                System.out.println(String.format("top %s frequent of %s is %s", k, Arrays.toString(nums),
                    Arrays.toString(instance.topKFrequent(nums, k).toArray(new Integer[0]))));

                nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3};
                k = 2;
                System.out.println(String.format("top %s frequent of %s is %s", k, Arrays.toString(nums),
                    Arrays.toString(instance.topKFrequent(nums, k).toArray(new Integer[0]))));
            }
        });

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        return topKFrequent2(nums, k);
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            return new ArrayList<>(0);
        }
        HashMap<Integer, Integer> frequentMap = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            if (frequentMap.containsKey(num)) {
                frequentMap.put(num, frequentMap.get(num) + 1);
            } else {
                frequentMap.put(num, 1);
            }
        }

        // 注意一点：int的hashCode()还是int本身的值
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        // bucket数组，下标就是出现的次数，所以从后向前遍历就好了
        List<Integer> result = new ArrayList<>(k);
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null || bucket[i].isEmpty()) {
                continue;
            }
            for (int j = 0; j < bucket[i].size(); j++) {
                result.add(bucket[i].get(j));
                k--;
                if (k <= 0) {
                    return result;
                }
            }
        }
        return result;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            return new ArrayList<>(0);
        }
        HashMap<Integer, Integer> frequentMap = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            if (frequentMap.containsKey(num)) {
                frequentMap.put(num, frequentMap.get(num) + 1);
            } else {
                frequentMap.put(num, 1);
            }
        }

        TreeMap<Integer, ArrayList<Integer>> frequentTreeMap = new TreeMap<>();
        ArrayList<Integer> numList;
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (frequentTreeMap.containsKey(entry.getValue())) {
                numList = frequentTreeMap.get(entry.getValue());
            } else {
                numList = new ArrayList<>();
            }
            numList.add(entry.getKey());
            frequentTreeMap.put(entry.getValue(), numList);
        }

        List<Integer> list = new ArrayList<>(k);
        for (ArrayList<Integer> tmpNumList : frequentTreeMap.values()) {
            for (int num : tmpNumList) {
                list.add(num);
                k--;
                if (k <= 0) {
                    break;
                }
            }
        }
        return list;
    }
}
