package n03_graphs;

public class LC1020NumberOfEnclaves
{
    private static final int[][] dir =
            {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };

    private int dfs(int[][] grid, int r, int c)
    {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
        int count = 1;
        grid[r][c] = 0;

        for (int[] d: dir)
        {
            count += dfs(grid, r + d[0], c + d[1]);
        }

        return count;
    }

    public int numEnclaves(int[][] grid)
    {
        // flood land cells on edge

        for (int r = 0; r < grid.length; r++)
        {
            dfs(grid, r, 0);
            dfs(grid, r, grid[0].length - 1);
        }

        for (int c = 0; c < grid[0].length; c++)
        {
            dfs(grid, 0, c);
            dfs(grid, grid.length - 1, c);
        }

        int numberOfLandCells = 0;

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                numberOfLandCells += dfs(grid, r, c);
            }
        }

        return numberOfLandCells;
    }
}
