package leet_code_contests.weekly.wc294_20220521;

public class LC2281SumOfTotalStrengthOfWizards
{
    // Attempt 1 - used DP and is NOT efficient
    public int totalStrength(int[] strength)
    {
        int mod = 1_000_000_000 + 7;
        long ret = 0;
        int n = strength.length;
        int[][] min = new int[n][n];
        int[][] sum = new int[n][n];
        int i, j, w;

        for (w = 1; w <= n; w++)
        {
            for (i = 0; i <= n - w; i++)
            {
                j = i + w - 1;
                if (i == j)
                {
                    min[i][i] = sum[i][i] = strength[i];
                }
                else
                {
                    min[i][j] = Math.min(min[i + 1][j], min[i][j - 1]);
                    sum[i][j] = sum[i + 1][j] + sum[i][j - 1] - sum[i + 1][j - 1];
                }
                ret = (ret + min[i][j] * sum[i][j]) % mod;

            }
        }

        return (int) ret;

    }
}
