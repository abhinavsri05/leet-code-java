package n05_dynamic_programming;/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 */

public class LC0121BestTimeToBuySellStock
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

    // 2/7/22 as part of DS-1
    public int maxProfit2(int[] prices) {
        int buy = 0;
        int sell = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < prices[buy])
            {
                buy = i;
            }

            if (prices[i] > prices[sell] || sell <= buy)
            {
                sell = i;
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
        }

        return maxProfit;

    }

    public int maxProfitLeetCode(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
//        int[] prices = { 2, 1, 2, 0, 1};
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices));
    }
}
