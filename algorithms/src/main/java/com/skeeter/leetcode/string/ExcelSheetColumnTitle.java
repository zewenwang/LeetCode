package com.skeeter.leetcode.string;

import com.skeeter.leetcode.UtilsKt;

/**
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * @author zewenwang created on 2018/2/5.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                ExcelSheetColumnTitle instance = new ExcelSheetColumnTitle();
                int number;

                number = 27;
                System.out.println(number + " -> " + instance.convertToTitle(number));
                number = 53;
                System.out.println(number + " -> " + instance.convertToTitle(number));
                number = 52;
                System.out.println(number + " -> " + instance.convertToTitle(number));
                number = 26;
                System.out.println(number + " -> " + instance.convertToTitle(number));
                number = 702;
                System.out.println(number + " -> " + instance.convertToTitle(number));
                number = 18278;
                System.out.println(number + " -> " + instance.convertToTitle(number));
            }
        });

    }

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        int mod;
        while (n > 0) {
            mod = (n - 1) % 26;
            builder.insert(0, (char) ('A' + mod));
            n = n / 26;
            if (mod == 25) {
                n--;
            }
        }
        return builder.toString();
    }
}
