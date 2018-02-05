package com.skeeter.leetcode.string;

import com.skeeter.leetcode.UtilsKt;

/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 * <p>
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * @author zewenwang created on 2018/2/5.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {

        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                ExcelSheetColumnNumber instance = new ExcelSheetColumnNumber();
                String string;

                string = "AB";
                System.out.println(string + " -> " + instance.titleToNumber(string));
                string = "BA";
                System.out.println(string + " -> " + instance.titleToNumber(string));
                   string = "ZZ";
                System.out.println(string + " -> " + instance.titleToNumber(string));
                   string = "ZZZ";
                System.out.println(string + " -> " + instance.titleToNumber(string));
            }
        });
    }

    public int titleToNumber(String string) {
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            num = num * 26 + (string.charAt(i) - 'A' + 1);
        }
        return num;
    }
}
