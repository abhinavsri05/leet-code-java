package n03_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC0200NumberOfIslands {
    // Attempt 1: DFS using a separate visited array
    private void explore(int r, int c, boolean[][] visited, char[][] grid)
    {
        if (visited[r][c]) return;

        visited[r][c] = true;

        // up
        if (r > 0 && grid[r - 1][c] == '1') explore(r - 1, c, visited, grid);

        // down
        if (r < grid.length - 1 && grid[r + 1][c] == '1') explore(r + 1, c, visited, grid);

        // left
        if (c > 0 && grid[r][c - 1] == '1') explore(r, c - 1, visited, grid);

        // right
        if (c < grid[0].length - 1 && grid[r][c + 1] == '1') explore(r, c + 1, visited, grid);
    }
    public int numIslands1(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int i, j;
        int count = 0;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    count++;
                    explore(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    // Attempt 2: DFS -  No separate visited array
    private void exploreNoVisited(int r, int c, char[][] grid)
    {
        grid[r][c] = '2'; // can be set to '0' as well

        // up
        if (r > 0 && grid[r - 1][c] == '1') exploreNoVisited(r - 1, c, grid);

        // down
        if (r < grid.length - 1 && grid[r + 1][c] == '1') exploreNoVisited(r + 1, c, grid);

        // left
        if (c > 0 && grid[r][c - 1] == '1') exploreNoVisited(r, c - 1, grid);

        // right
        if (c < grid[0].length - 1 && grid[r][c + 1] == '1') exploreNoVisited(r, c + 1, grid);
    }
    public int numIslands2(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int count = 0;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    exploreNoVisited(i, j, grid);
                }
            }
        }
        return count;
    }

    // Attempt 3: BFS
    public int numIslands3(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int i, j;

        Queue<int[]> q;
        int[] coordinate;
        int r, c;
        int count = 0;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '2';
                    while (!q.isEmpty())
                    {
                        coordinate = q.remove();
                        r = coordinate[0];
                        c = coordinate[1];

                        // Up
                        if (r > 0 && grid[r - 1][c] == '1')
                        {
                            q.add(new int[]{r - 1, c});
                            grid[r - 1][c] = '2';
                        }
                        // Down
                        if (r < m - 1 && grid[r + 1][c] == '1')
                        {
                            q.add(new int[]{r + 1, c});
                            grid[r + 1][c] = '2';
                        }
                        // Left
                        if (c > 0 && grid[r][c - 1] == '1')
                        {
                            q.add(new int[]{r, c - 1});
                            grid[r][c - 1] = '2';
                        }
                        // Down
                        if (c < n - 1 && grid[r][c + 1] == '1')
                        {
                            q.add(new int[]{r, c + 1});
                            grid[r][c + 1] = '2';
                        }
                    }
                }
            }
        }
        return count;
    }
}
