package com.datastructureandalgorithms.algorithms.leetcode;

/**
 * @author prachishah Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ You
 * are given an array prices where prices[i] is the price of a given stock on the ith day. You want
 * to maximize your profit by choosing a single day to buy one stock and choosing a different day in
 * the future to sell that stock. Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0. Example 1: Input: prices = [7,1,5,3,6,4] Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Note that
 * buying on day 2 and selling on day 1 is not allowed because you must buy before you sell. Example
 * 2: Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions are done and
 * the max profit = 0.
 */
public class BestTimeBuySellStock {

  public static void main(String[] args) {
    BestTimeBuySellStock bst = new BestTimeBuySellStock();
    // Price i is the price of given stock on i-th day.
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    int[] pricesNoProfit = new int[]{7, 6, 4, 3, 1};
    System.out.println(bst.maxProfitBruteForce(prices));
    System.out.println(bst.maxProfitBruteForce(pricesNoProfit));
    System.out.println(bst.maxProfitOptimized(prices));
    System.out.println(bst.maxProfitOptimized(pricesNoProfit));
  }

  public int maxProfitBruteForce(int[] prices) {
    // Time: O(nxn). Space: O(n) + O(1) for two variables.
    // Data validation
    if (prices == null || prices.length < 2) {
      System.out.println(
          "Cannot find max profit. Kindly enter an array with at least two positive numbers.");
      return -1;
    }

    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }

  public int maxProfitOptimized(int[] prices) { // Single-pass
    // Time: O(n). Space: O(n) + O(1) for two variables.
    // Data validation
    if (prices == null || prices.length < 2) {
      System.out.println(
          "Cannot find max profit. Kindly enter an array with at least two positive numbers.");
      return 0;
    }

    // We can maintain two variables - minprice and maxprofit corresponding to the smallest valley
    // and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
    int maxProfit = 0;
    int minProfit = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minProfit) {  // Smallest stock price value
        minProfit = prices[i];
      } else if (prices[i] - minProfit > maxProfit) {
        maxProfit = prices[i] - minProfit;
      }
    }
    return maxProfit;
  }

}