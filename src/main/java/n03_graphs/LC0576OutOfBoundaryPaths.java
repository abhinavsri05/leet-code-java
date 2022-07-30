package n03_graphs;

public class LC0576OutOfBoundaryPaths
{
    // Uses DFS - Times out
    // Needs to be optimized already visited paths
    /*
        private static final int[][] directions =
        {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
    private long dfs(int m, int n, int maxMove, int startRow, int startColumn, int move)
    {

        if (move > maxMove) return 0l;

        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1l;
        long paths = 0;

        for (int[] d: directions)
            paths += dfs(m, n, maxMove, startRow + d[0], startColumn + d[1], move + 1);

        return paths;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {

        return (int)(dfs(m, n, maxMove, startRow, startColumn, 0) % 1_000_000_007);

    }
     */

    // Below solution tries to memoize but we cannot just memoize since there is an upper bound on number of moves
    /*
    class Solution {
    private static final int[][] directions =
        {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

    private long dfs(long[][] dp, int m, int n, int maxMove, int startRow, int startColumn, int move)
    {
        if (move > maxMove) return 0l;

        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1l;
        else
        {
            if (dp[startRow][startColumn] > 0)
                return dp[startRow][startColumn];
        }
        long paths = 0;

        for (int[] d: directions)
        {

            paths += (dfs(dp, m, n, maxMove, startRow + d[0], startColumn + d[1], move + 1) % 1_000_000_007);
        }
        dp[startRow][startColumn] = paths;
        return paths;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        long[][] dp = new long[m][n];
        long p = dfs(dp, m, n, maxMove, startRow, startColumn, 0);
        System.out.println(p);
        return (int)(dp[startRow][startColumn] % 1_000_000_007);

    }
}
     */
}
