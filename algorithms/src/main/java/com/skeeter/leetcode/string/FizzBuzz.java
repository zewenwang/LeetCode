package com.skeeter.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 *
 * @author zewenwang created on 2018/1/29.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>(n);
        int fizz = 1;
        int buzz = 1;
        for (int i = 1; i <= n; i++) {
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 1;
                buzz = 1;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 1;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 1;
            } else {
                list.add(String.valueOf(i));
                fizz++;
                buzz++;
            }
        }
        return list;
    }
}
