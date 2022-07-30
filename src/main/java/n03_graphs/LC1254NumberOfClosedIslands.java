package n03_graphs;

public class LC1254NumberOfClosedIslands
{
    int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private void dfs(int[][] grid, int row, int col)
    {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1)
            return;

        grid[row][col] = 1;

        for (int[] d: directions)
        {
            dfs(grid, row + d[0], col + d[1]);
        }
    }

    public int closedIsland(int[][] grid)
    {
        int closedIslands = 0;
        int r, c;
        // Flood islands at the edge of the world
        for (c = 0; c < grid[0].length; c++)
        {
            if (grid[0][c] == 0) dfs(grid, 0, c);
            if (grid[grid.length - 1][c] == 0) dfs(grid, grid.length - 1, c);
        }

        for (r = 0; r < grid.length; r++)
        {
            if (grid[r][0] == 0) dfs(grid, r, 0);
            if (grid[r][grid[0].length - 1] == 0) dfs(grid, r, grid[0].length - 1);
        }

        // Count CC

        for (r = 1; r < grid.length - 1; r++)
        {
            for (c = 1; c < grid[0].length - 1; c++)
            {
                if (grid[r][c] == 0)
                {
                    closedIslands++;
                    dfs(grid, r, c);
                }
            }
        }

        return closedIslands;
    }
}
