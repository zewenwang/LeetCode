package com.skeeter.leetcode.arrays;

import com.skeeter.leetcode.UtilsKt;

import java.util.Arrays;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * <p>
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * - You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * - After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * <p>
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * @author zewenwang created on 2018/2/11.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        UtilsKt.runWithTime(new Runnable() {
            @Override
            public void run() {
                BestTimeToBuyAndSellStockWithCooldown instance = new BestTimeToBuyAndSellStockWithCooldown();
                int[] prices;

                prices = new int[]{1, 2, 3, 0, 2};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices) + " and should be 3");
                prices = new int[]{2, 1, 2, 0, 1};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices) + " and should be 1");
                prices = new int[]{6, 1, 3, 2, 4, 7};
                System.out.println("max profit of array: " + Arrays.toString(prices)
                    + " is : " + instance.maxProfit(prices) + " and should be 6");
            }
        });
    }

    /**
     * buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。
     * sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。
     * rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。
     * 我们写出递推式为：
     * buy[i]  = max(rest[i-1] - price, buy[i-1])
     * sell[i] = max(buy[i-1] + price, sell[i-1])
     * rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
     * <p>
     * 由于buy[i] <= rest[i]， 即rest[i] = max(sell[i-1], rest[i-1])
     * 由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]
     * <p>
     * buy[i]  = max(sell[i-2] - price, buy[i-1])
     * sell[i] = max(buy[i-1] + price, sell[i-1])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int buy = Integer.MIN_VALUE, preBuy = 0;
        int sell = 0, preSell = 0;
        for (int i = 0; i < prices.length; i++) {
            preBuy = buy;
            buy = Math.max(preSell - prices[i], preBuy);
            preSell = sell;
            sell = Math.max(preBuy + prices[i], preSell);
        }
        return sell;
    }

}
