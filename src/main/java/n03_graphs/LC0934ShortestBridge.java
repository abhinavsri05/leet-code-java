package n03_graphs;

public class LC0934ShortestBridge
{
    /*
    Using DFS and BFS

        private static final int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    private void identifyIsland(ArrayDeque<int[]> queue, int[][] grid, int r, int c)
    {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
            return;

        grid[r][c] = 2;
        queue.add(new int[]{r, c, 0});

        for (int[] d: dirs)
        {
            identifyIsland(queue, grid, r + d[0], c + d[1]);
        }
    }


    public int shortestBridge(int[][] grid)
    {
        int i, j;
        int n = grid.length;
        int r, c;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // Add coordinates of one island to the queue
        out:
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    identifyIsland(queue, grid, i, j);
                    break out;
                }
            }
        }

        int minLength = 101;

        while (queue.size() > 0)
        {
            int[] d = queue.poll();

            for (int[] dir: dirs)
            {
                r = d[0] + dir[0];
                c = d[1] + dir[1];

                if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 2)
                    continue;

                if (grid[r][c] == 0)
                {
                    queue.add(new int[]{r, c, d[2] + 1});
                    grid[r][c] = 2;
                }

                if (grid[r][c] == 1)
                    minLength = Math.min(minLength, d[2]);
            }
        }

        return minLength;
    }
     */

    // Bi Directional BFS
}
