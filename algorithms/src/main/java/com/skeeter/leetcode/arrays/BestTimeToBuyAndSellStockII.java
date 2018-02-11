package com.skeeter.leetcode.arrays;

import com.skeeter.leetcode.UtilsKt;

import java.util.Arrays;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description
 * <p>
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * @author zewenwang created on 2018/2/10.
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                BestTimeToBuyAndSellStockII instance = new BestTimeToBuyAndSellStockII();
                int[] prices;

                prices = new int[]{7, 1, 5, 3, 6, 4};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices) + " and should be 7");
                prices = new int[]{1, 7, 2, 3, 6, 7, 6, 7};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices) + " and should be 12");

            }
        });
    }

    public int maxProfit(int[] prices) {
        return maxProfit2(prices);
    }

    /**
     * 折线原理：
     * A、B、C、D四点，A<B, C<D, 则 D-A < (B-A + D-C)
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        int low, high;

        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            low = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            high = prices[i];
            maxProfit += high - low;
        }

        return maxProfit;
    }

    /**
     * 折线原理：
     * A、B、C四点，A<B<C, 则 C-A = C-B + B-A
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
