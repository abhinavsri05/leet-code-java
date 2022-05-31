package n05_dynamic_programming;

public class LC0063UniquePathsII
{
    // Attempt 1
    public int uniquePathsWithObstacles1(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int i, j;

        for (i = 1; i <= m; i++)
        {
            if (obstacleGrid[i - 1][0] == 1)
                break;
            dp[i][1] = 1;
        }
        for (j = 1; j <= n; j++)
        {
            if (obstacleGrid[0][j - 1] == 1)
                break;
            dp[1][j] = 1;
        }

        for (i = 2; i <= m; i++)
        {
            for (j = 2; j <= n; j++)
            {
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];

    }

    // Attempt 2
    public int uniquePathsWithObstacles2(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int i, j;

        for (i = 1; i <= m; i++)
        {
            for (j = 1; j <= n; j++)
            {
                if (i == 1 && j == 1 && obstacleGrid[i - 1][j - 1] == 0)
                {
                    dp[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    // Attempt 3
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int i, j;

        for (i = 1; i <= m; i++)
        {
            for (j = 1; j <= n; j++)
            {
                if (i == 1 && j == 1)
                {
                    dp[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

}
