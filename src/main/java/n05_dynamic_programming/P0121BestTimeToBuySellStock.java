package n05_dynamic_programming;/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 */

public class P0121BestTimeToBuySellStock
{
    public static int maxProfit(int[] prices)
    {

        int buy = prices[0];
        int sell = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > buy && prices[i] > sell) {
                System.out.println("Sell Sell Updated: " + prices[i]);
                sell = prices[i];
            }
            else
                if (prices[i] < buy)
                {
                    System.out.println("Buy and Sell Updated: " + prices[i]);
                    buy = prices[i];
                    sell = prices[i];
                }
            maxProfit = Math.max(maxProfit, sell - buy);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] prices = { 2, 1, 2, 0, 1};
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices));
    }
}
