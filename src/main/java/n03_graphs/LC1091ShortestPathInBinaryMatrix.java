package n03_graphs;

import java.util.LinkedList;

public class LC1091ShortestPathInBinaryMatrix
{
    private static final int[][] directions = new int[][]{
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    private void addNeighbor(int r, int c, int level, int[][]grid, LinkedList<int[]> list)
    {
        int n = grid.length;
        int newR, newC;

        for (int[] d: directions)
        {
            newR = r + d[0];
            newC = c + d[1];
            if (newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0)
                list.add(new int[]{r + d[0], c + d[1], level});
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid)
    {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        LinkedList<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});

        int[] curr;

        int minLen = -1, r, c;

        while (!queue.isEmpty())
        {
            curr = queue.remove();

            r = curr[0];
            c = curr[1];

            if (grid[r][c] != 0) continue; // already explored

            grid[r][c] = 2;  // visited

            if (r == n - 1 && c == n - 1)
            {
                minLen = curr[2];
                break;
            }

            addNeighbor(r, c, curr[2] + 1, grid, queue);
        }

        return minLen;

    }
}
