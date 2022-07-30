package n03_graphs;

public class LC1905CountSubIslands
{
    private static final int[][] dirs =
            {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };

    private boolean dfs(int[][] grid1, int[][] grid2, int m, int n, int r, int c)
    {
        if (r < 0 || r >= m || c < 0 || c >= n || grid2[r][c] == 0)
        {
            return true;
        }

        grid2[r][c] = 0;

        boolean ret = grid1[r][c] != 0;

        for (int[] d: dirs)
        {
            ret = ret & dfs(grid1, grid2, m, n, r + d[0], c + d[1]);
        }

        return ret;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2)
    {
        // All nodes in a connected components in the grid 2 must be there in grid1.

        int m = grid2.length;
        int n = grid2[0].length;
        int r, c;
        int count = 0;
        for (r = 0; r < m; r++)
        {
            for (c = 0; c < n; c++)
            {
                if (grid2[r][c] == 1 && dfs(grid1, grid2, m, n, r, c))
                {
                    count++;
                }
            }
        }

        return count;
    }
}
