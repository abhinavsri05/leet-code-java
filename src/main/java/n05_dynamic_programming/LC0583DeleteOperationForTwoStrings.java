package n05_dynamic_programming;

public class LC0583DeleteOperationForTwoStrings
{
    public int minDistance1(String word1, String word2)
    {
        int l1 = word1.length();
        int l2 = word2.length();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];

        int i, j;

        for (i = 1; i <= l1; i++)
        {
            for (j = 1; j <= l2; j++)
            {
                if (w1[i - 1] == w2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return l1 + l2 - 2 * dp[l1][l2];
    }

    // Attempt 2 without using LCS. See LC solution #4 for explanation

    public int minDistance2(String word1, String word2)
    {
        int l1 = word1.length();
        int l2 = word2.length();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];

        int i, j;

        for (i = 0; i <= l1; i++)
        {
            for (j = 0; j <= l2; j++)
            {
                if (i == 0 || j == 0) // remove ( i + j) characters if one of the strings is empty
                    dp[i][j] = i + j;
                else if (w1[i - 1] == w2[j - 1]) // If same character then no deletion required
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1; // Find minimum of the two deletions and add 1 to it.
            }
        }

        return dp[l1][l2];
    }

    // Attempt 3: Using O(n) space. Note that only previous row is needed in previous solution
    public int minDistance(String word1, String word2)
    {
        int l1 = word1.length();
        int l2 = word2.length();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[2][l2 + 1];

        int i, j;

        for (i = 0; i <= l1; i++)
        {
            for (j = 0; j <= l2; j++)
            {
                if (i == 0 || j == 0)
                    dp[i & 1][j] = i + j;
                else if (w1[i - 1] == w2[j - 1])
                    dp[i & 1][j] = dp[(i + 1) & 1][j - 1];
                else
                    dp[i & 1][j] = Math.min(dp[(i + 1) & 1][j], dp[i & 1][j - 1]) + 1;
            }
        }

        return dp[(i + 1) & 1][l2];

    }
}
