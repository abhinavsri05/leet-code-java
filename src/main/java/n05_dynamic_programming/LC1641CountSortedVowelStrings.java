package n05_dynamic_programming;

public class LC1641CountSortedVowelStrings
{
    public int countVowelStrings(int n)
    {
        int[][] dp = new int[n + 1][5 + 1];

        int i, j;

        // Base case

        for (i = 1; i <= 5; i++)
            dp[1][i] = i;  // String of length 1 using i vowels

        // Recurrence
        // Possible scenarios - String of length i - 1 using all j vowels + String of length i using j - 1 vowels

        for (i = 2; i <= n; i++)
            for (j = 1; j <= 5; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[n][5];
    }
}
