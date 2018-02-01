package com.skeeter.leetcode.math;

/**
 * @author zewenwang created on 2018/1/29.
 */
public class Power {

    public static void main(String[] args) {
        Power instance = new Power();
        double x;
        int n;

        x = 1;
        n = 0;
        System.out.println("myPow(" + x + " , " + n + "): " + instance.myPow(x, n));
        x = -1;
        n = 3;
        System.out.println("myPow(" + x + " , " + n + "): " + instance.myPow(x, n));
        x = 2;
        n = 10;
        System.out.println("myPow(" + x + " , " + n + "): " + instance.myPow(x, n));
        x = 1.1;
        n = 2;
        System.out.println("myPow(" + x + " , " + n + "): " + instance.myPow(x, n));
        x = 2;
        n = -2;
        System.out.println("myPow(" + x + " , " + n + "): " + instance.myPow(x, n));

    }

    public double myPow(double x, int n) {
        if (x == 1 || x == 0) {
            return x;
        } else if (x == -1) {
            if ((n & 1) == 1) {
                return -1;
            } else {
                return 1;
            }
        }

        double result = 1;
        if (n == 0) {
            return result;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n > 0) {
                    result *= x;
                } else {
                    result /= x;
                }
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public double myPow3(double x, int n) {
        double result = 1;
        int i;
        if (n < 0) {
            i = -n;
        } else {
            i = n;
        }
        while (i > 0) {
            result *= x;
            i--;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double myPow2(double x, int n) {
        return Math.pow(x, n);
    }
}
