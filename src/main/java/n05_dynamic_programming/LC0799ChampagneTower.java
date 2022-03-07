package n05_dynamic_programming;

public class LC0799ChampagneTower {

    // Attempt 1: DOES NOT WORK
    // Middle one's will start overflowing before the corner one's
    public double champagneTower1(int poured, int query_row, int query_glass)
    {
        int prevRowQty = query_row * (query_row + 1) / 2;

        if (poured < prevRowQty) return 0d;
        if (poured >= prevRowQty + query_row + 1) return 1d;

        int excess = poured - prevRowQty;
        System.out.println("Excess: " + excess);

        double each = excess * 1.0d / (2.0d + 2.0d * (query_row  - 1.0d));

        if (query_glass == 0 || query_glass == query_row)
            return each;
        else
            return 2 * each;
    }

    // Attempt 2
    public double champagneTower2(int poured, int query_row, int query_glass)     {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;

        int i, j;

        for (i = 1; i <= query_row; i++)
        {
            for (j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    dp[i][j] = Math.max(0.0d, (dp[i - 1][0] - 1.0d) / 2.0d);
                }
                else
                {
                    dp[i][j] = Math.max(0.0d, (dp[i - 1][j - 1] - 1.0d) / 2.0d) + Math.max(0.0d, (dp[i - 1][j] - 1.0d) / 2.0d);
                }
            }
        }

        return Math.min(1.0d, dp[query_row][query_glass]);

    }

    // Attempt 3
    // Do not need an array. Just need to track current and previous rows.
    public double champagneTower(int poured, int query_row, int query_glass)     {
        double[][] dp = new double[2][query_row + 1];
        dp[0][0] = poured;

        int i, j;

        for (i = 1; i <= query_row; i++)
        {
            for (j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    dp[i & 1][j] = Math.max(0.0d, (dp[(i - 1) & 1][0] - 1.0d) / 2.0d);
                }
                else
                {
                    dp[i & 1][j] =  Math.max(0.0d, (dp[(i - 1) & 1][j - 1] - 1.0d) / 2.0d) +
                                    Math.max(0.0d, (dp[(i - 1) & 1][j] - 1.0d) / 2);
                }
            }
        }

        return Math.min(1.0d, dp[query_row & 1][query_glass]);
    }

}
