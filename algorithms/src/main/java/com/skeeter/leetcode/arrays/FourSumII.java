package com.skeeter.leetcode.arrays;

import java.util.HashMap;

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/description/
 * <p>
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] +
 * B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the
 * range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
 * <p>
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output:
 * 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author zewenwang created on 2018/2/5.
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int sum;
        Integer tmp;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                tmp = hashMap.get(sum);
                hashMap.put(sum, (tmp == null ? 0 : tmp) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = C[i] + D[j];
                if (hashMap.containsKey(-sum)) {
                    result += hashMap.get(-sum);
                }
            }
        }
        return result;
    }
}
