package n05_dynamic_programming;

public class LC0746MinCostClimbingStairs
{
    public int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        // Below 2 not seeded since n >= 2
        // if (n == 1) return cost[0];
        // if (n == 2) return Math.min(cost[0], cost[1]);

        int i;

        int[] dp = new int[n + 1];

        for (i = 2; i <= n; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        return dp[n];
    }
}
