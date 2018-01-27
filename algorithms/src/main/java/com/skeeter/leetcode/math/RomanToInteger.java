package com.skeeter.leetcode.math;

/**
 * <a href="https://leetcode.com/problems/two-sum/">13. Roman to Integer</a>
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * 规则：
 * 1. 基本符号：I（1）、V（5）、X（10）、L（50）、C（100）、D（500）、 M（1000）
 * 2. 组数规则：基本数字 Ⅰ、X 、C 中的任何一个、自身连用构成数目、或者放在大数的右边连用构成数目、都不能超过三个；放在大数的左边只能用一个；
 * 不能把基本数字 V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目、只能使用一个；
 * <p>
 * 示例：
 * Ⅰ－1、ⅠⅠ－2、ⅠⅠⅠ－3、IV－4、Ⅴ－5、VI－6、VII－7、VIII－8、IX－9、
 * Ⅹ－10、XI－11、XII－12、XIII－13、XIV－14、XV－15、XVI－16、XVII－17、XVIII－18、XIX－19、XX－20、XXX－30、
 * C－100、CC－200、CMXCIX－999、
 * M－1000、MC－1100、MCD－1400、MD－1500、MDC－1600、MDCLXVI－1666、MMMCMXCIX－3999
 *
 * @author zewenwang created on 2018/1/27.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        String romanStr;

//        romanStr = "III";//3
//        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "VI";//6
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "XIV";//14
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "CC";//200
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "CMXCIX";//999
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "MDCLXVI";//1666
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
        romanStr = "MMMCMXCIX";//3999
        System.out.println("romanToInt(" + romanStr + ") = " + instance.romanToInt(romanStr));
    }

//    public int romanToInt(String romanStr) {
//        int romanInt = 0;
//        romanInt += romanStr.
//
//        return romanInt;
//    }


    public int getRomanMapInt(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

            default:
                return 0;
        }
    }

    public int romanToInt(String romanStr) {
        int romanInt = 0;
        int lastInt = 0;
        int currentInt;
        for (int i = romanStr.length() - 1; i >= 0; i--) {
            currentInt = getRomanMapInt(romanStr.charAt(i));
            if (currentInt < lastInt) {
                romanInt -= currentInt;
            } else {
                romanInt += currentInt;
            }
            lastInt = currentInt;
        }
        return romanInt;
    }


    public int romanToInt1(String romanStr) {
        int romanInt = 0;
        int lastInt = 0;
        int currentInt;
        for (int i = romanStr.length() - 1; i >= 0; i--) {
            switch (romanStr.charAt(i)) {
                case 'I':
                    currentInt = 1;
                    break;
                case 'V':
                    currentInt = 5;
                    break;
                case 'X':
                    currentInt = 10;
                    break;
                case 'L':
                    currentInt = 50;
                    break;
                case 'C':
                    currentInt = 100;
                    break;
                case 'D':
                    currentInt = 500;
                    break;
                case 'M':
                    currentInt = 1000;
                    break;
                default:
                    currentInt = 0;
                    break;
            }

            if (currentInt < lastInt) {
                romanInt -= currentInt;
            } else {
                romanInt += currentInt;
            }
            lastInt = currentInt;
        }
        return romanInt;
    }


}
