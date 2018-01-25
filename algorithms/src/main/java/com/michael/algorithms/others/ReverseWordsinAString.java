/**
 */
package com.michael.algorithms.others;

/**
 * Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification:
 * 
 * What constitutes a word? A sequence of non-space characters constitutes a
 * word.
 * 
 * Could the input string contain leading or trailing spaces? Yes. However, your
 * reversed string should not contain leading or trailing spaces.
 * 
 * How about multiple spaces between two words? Reduce them to a single space in
 * the reversed string.
 * 
 * @author michael at 2015年5月6日
 * 
 */
public class ReverseWordsinAString {
    public class Solution {
        /** 反复用StringBuilder的reverse()也不是很好 */
        public String reverseWords3(String s) {
            StringBuilder builder = new StringBuilder(s.trim());
            s = builder.reverse().toString();
            String[] array = s.split("[ ]+");
            builder = new StringBuilder();
            for (String string : array) {
                if (!string.equals("")) {
                    builder.append(new StringBuilder(string).reverse());
                    builder.append(' ');
                }
            }
            return builder.toString().trim();
        }

        /** 反转两次，最浪费时间 */
        public String reverseWords2(String s) {
            char[] cs = s.trim().toCharArray();
            reverse(cs, 0, cs.length);
            StringBuilder builder = new StringBuilder();
            for (int i = 0, j = 0; i <= cs.length; i++) {
                if (i == cs.length
                        || (' ' == cs[i] && (i > 0 && cs[i - 1] != ' '))) {
                    reverse(cs, j, i);
                    builder.append(cs, j, i - j);
                    builder.append(' ');
                    j++;
                } else if (i > 0 && cs[i - 1] == ' ') {
                    j++;
                }
            }

            return builder.toString();
        }

        public void reverse(char[] string, int start, int end) {
            if (end - start <= 1) {
                return;
            }
            for (int i = ((start + end) >> 1) - 1; i >= start; i--) {
                char ch = string[i];
                string[i] = string[end - 1 - i + start];
                string[end - 1 - i + start] = ch;
            }
        }

        /** 直接从后向前查找，不做反转，只做copy的工作，最省时省空间 */
        public String reverseWords(String s) {
            char[] cs = s.trim().toCharArray();
            if (cs.length <= 1) {
                return new String(cs);
            }
            StringBuilder builder = new StringBuilder();
            boolean start = false;
            for (int i = cs.length - 1, j = cs.length - 1; i >= 0; i--) {
                if (!start && cs[i] != ' ') {
                    j = i;
                    start = true;
                } else if (start && cs[i] == ' ') {
                    builder.append(cs, i + 1, j - i);
                    builder.append(' ');
                    start = false;
                }

                if (i == 0 && start) {
                    builder.append(cs, i, j - i + 1);
                }
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new ReverseWordsinAString().new Solution();
        String string = "hi!";
        System.out.println(solution.reverseWords(string));
    }
}
