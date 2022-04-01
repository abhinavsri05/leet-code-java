package n05_dynamic_programming;

import java.util.Arrays;

public class LC0322CoinChange
{
    public int coinChange(int[] coins, int amount)
    {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        int i, j;

        for (i = 1; i <= amount; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
