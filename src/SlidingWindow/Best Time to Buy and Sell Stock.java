package SlidingWindow;
//121. Best Time to Buy and Sell Stock
/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0. */
class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int profit=0;
        //这个循环的思路是最为关键的，好好体会多几遍
        for(int price:prices){
            buy=Math.min(buy, price);
            profit=Math.max(profit, price-buy);
        }
        return profit;
    }
}