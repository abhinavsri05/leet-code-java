package n03_graphs;

import java.util.Deque;
import java.util.LinkedList;

public class P0994RottenOranges {

    // First Attempt - Not optimal space/time. Uses BFS
    private int[] bfs(Deque<int[]> q, int[][] grid, int rottenCount, int timeTaken)
    {
        int[] topOfQ;
        int i, j, steps;
        int m = grid.length;
        int n = grid[0].length;
        while(q.size() > 0)
        {
            topOfQ = q.remove();
            i = topOfQ[0];
            j = topOfQ[1];
            steps = topOfQ[2];

            rottenCount++;

            // up

            if (i > 0 && grid[i - 1][j] == 1)
            {
                q.add(new int[]{i - 1, j, steps + 1});
                timeTaken = steps + 1;
                grid[i - 1][j] = -2; // so that it is not added again
                // rottenCount++;
            }

            // down

            if (i < m - 1 && grid[i + 1][j] == 1)
            {
                q.add(new int[]{i + 1, j, steps + 1});
                timeTaken = steps + 1;
                grid[i + 1][j] = -2; // so that it is not added again
                // rottenCount++;
            }

            // left

            if (j > 0 && grid[i][j - 1] == 1)
            {
                q.add(new int[]{i, j - 1, steps + 1});
                timeTaken = steps + 1;
                grid[i][j - 1] = -2; // so that it is not added again
                // rottenCount++;
            }

            // right

            if (j < n - 1 && grid[i][j + 1] == 1)
            {
                q.add(new int[]{i, j + 1, steps + 1});
                timeTaken = steps + 1;
                grid[i][j + 1] = -2; // so that it is not added again
                // rottenCount++;
            }

        }
        return new int[]{rottenCount, timeTaken};
    }

    public int orangesRotting(int[][] grid)
    {
        Deque<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int timeTaken = 0;
        int rottenCount = 0;
        int countOranges = 0;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (grid[i][j] != 0) countOranges++;
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i, j, 0});
                    grid[i][j] = -2;
                }
            }
        }
        int[] returnValues = bfs(q, grid, rottenCount, timeTaken);
        // return this.timeTaken;
        // System.out.println(returnValues[0] + "," + returnValues[1]);
        return returnValues[0] == countOranges ? returnValues[1] : -1;
    }
}
