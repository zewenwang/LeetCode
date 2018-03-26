package com.skeeter.leetcode.string;

import com.skeeter.leetcode.UtilsKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author zewenwang created on 2018/2/25.
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                GenerateParentheses instance = new GenerateParentheses();
                int n;
                List<String> result;

//                n = 1;
//                result = instance.generateParenthesis(n);
//                System.out.println("n: " + n);
//                System.out.println("result.size(): " + result.size()
//                    + " : " + Arrays.toString(result.toArray(new String[0])));
//                System.out.println();

                n = 2;
                result = instance.generateParenthesis(n);
                System.out.println("n: " + n);
                System.out.println("result.size(): " + result.size()
                    + " : " + Arrays.toString(result.toArray(new String[0])));
                System.out.println();

                n = 3;
                result = instance.generateParenthesis(n);
                System.out.println("n: " + n);
                System.out.println("result.size(): " + result.size()
                    + " : " + Arrays.toString(result.toArray(new String[0])));
                System.out.println();


            }
        });
    }


    public List<String> generateParenthesis(int n) {
        ArrayList<String> resultList = new ArrayList<>(n << 1);
        if (n <= 0) {
            return resultList;
        }
        backtrack(resultList, new char[n * 2], 0, 0, 0, n);
        return resultList;
    }

    public void backtrack(List<String> resultList, char[] currentString, int currentIndex,
        int left, int right, int n) {
        if (currentIndex == n << 1) {
            resultList.add(new String(currentString));
            return;
        }

        if (left < n) {
            currentString[currentIndex] = '(';
            backtrack(resultList, currentString, currentIndex + 1, left + 1, right, n);
        }
        if (right < left) {
            currentString[currentIndex] = ')';
            backtrack(resultList, currentString, currentIndex + 1, left, right + 1, n);
        }
    }

}
