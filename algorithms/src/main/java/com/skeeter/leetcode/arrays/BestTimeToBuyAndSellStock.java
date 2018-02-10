package com.skeeter.leetcode.arrays;

import com.skeeter.leetcode.UtilsKt;

import java.util.Arrays;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <p>
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author zewenwang created on 2018/2/10.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
                int[] prices;

                prices = new int[]{7, 1, 5, 3, 6, 4};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices));
                prices = new int[]{7, 6, 4, 3, 1};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices));

            }
        });
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int maxProfit = 0;

        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
