package com.skeeter.leetcode.string;

/**
 * 678. Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 * <p>
 * Note:
 * The string size will be in the range [1, 100].
 * <p>
 * Input: "()"; Output: True
 * Input: "(*)";  Output: True
 * Input: "(*))"; Output: True
 *
 * @author zewenwang created on 30/01/2018.
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString instance = new ValidParenthesisString();
        String string;

//        string = "";
//        System.out.println(string + " : " + instance.checkValidString(string));
//        string = "()";
//        System.out.println(string + " : " + instance.checkValidString(string));
        string = "(*)";
        System.out.println(string + " : " + instance.checkValidString(string));
        string = "(*))";
        System.out.println(string + " : " + instance.checkValidString(string));
        string = "****";
        System.out.println(string + " : " + instance.checkValidString(string));
        string = "(**(";
        System.out.println(string + " : " + instance.checkValidString(string));
        string = "(((*)(*))((*";
        System.out.println(string + " : " + instance.checkValidString(string));

    }


    public boolean checkValidString(String string) {
        return checkValidString2(string);
    }

    public boolean checkValidString2(String string) {
        if (string == null) {
            return false;
        }
        char ch;

        int low = 0;  // low>0时 * 一直充当) ，否则丢弃掉此 * ，最终low==0
        int high = 0; // * 一直充当( ，如果仍<0，说明）太多了
        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);

            if (ch == '*') {
                // 此时如果low==0 , *不必充当），丢弃掉
                if (low > 0) {
                    low--;
                }
                high++;
            } else if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                // 此时如果low==0 ,     1. 有*充当了），其实没必要充当，所以此处可以不减
                //                     2. 之前没有*充当），那么就可以直接返回false了，但这件事已经交给了high，所以low其实也可以不做处理
                if (low > 0) {
                    low--;
                }
                high--;
            }
            if (high < 0) {
                return false;
            }
        }
        return low <= 0;
    }

    /**
     * （ +1 , ) -1
     */
    public boolean checkValidString1(String string) {
        if (string == null) {
            return false;
        }
        char ch;

        // parenthesisCount代表（的个数，从左到右遍历
        int parenthesisCount = 0;
        int starCount = 0;
        int i = 0;
        while (parenthesisCount >= 0 && i < string.length()) {
            ch = string.charAt(i);
            if (ch == '*') {
                starCount++;
            } else if (ch == '(') {
                parenthesisCount++;
            } else if (ch == ')') {
                if (parenthesisCount == 0 && starCount > 0) {
                    starCount--;
                } else {
                    parenthesisCount--;
                }
            }
            i++;
        }

        if (i < string.length() || (starCount - parenthesisCount) < 0) {
            return false;
        }

        parenthesisCount = 0;
        starCount = 0;
        i = string.length() - 1;
        while (parenthesisCount <= 0 && i >= 0) {
            ch = string.charAt(i);
            if (ch == '*') {
                starCount++;
            } else if (ch == '(') {
                if (parenthesisCount == 0 && starCount > 0) {
                    starCount--;
                } else {
                    parenthesisCount++;
                }
            } else if (ch == ')') {
                parenthesisCount--;
            }
            i--;
        }

        return i < 0 && starCount + parenthesisCount >= 0;
    }
}
