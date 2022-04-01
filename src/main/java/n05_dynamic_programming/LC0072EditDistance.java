package n05_dynamic_programming;

public class LC0072EditDistance
{
    public int minDistance(String word1, String word2)
    {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int l1 = w1.length;
        int l2 = w2.length;

        int i, j;

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (i = 0; i <= l1; i++)
        {
            for (j = 0; j <= l2; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = i + j;
                    continue;
                }
                if (w1[i - 1] == w2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[l1][l2];
    }
}
