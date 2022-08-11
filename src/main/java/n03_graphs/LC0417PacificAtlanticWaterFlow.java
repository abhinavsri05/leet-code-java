package n03_graphs;

import java.util.ArrayList;
import java.util.List;

public class LC0417PacificAtlanticWaterFlow
{
    private static final int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    private void helperDFS(int[][] heights, int m, int n, int[][] visited, int mask, int row, int col, int prevHeight)
    {
        if (row < 0 || row >= m || col < 0 || col >= n || (visited[row][col] & mask) == mask || heights[row][col] < prevHeight) return;

        visited[row][col] |= mask;

        for (int[] d : dirs)
        {
            helperDFS(heights, m, n, visited, mask, row + d[0], col + d[1], heights[row][col]);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        int m = heights.length;
        int n = heights[0].length;

        int[][] visited = new int[m][n];

        List<List<Integer>> output = new ArrayList<>();

        int i, j;

        // Pacific

        // Top row
        for (i = 0; i < n; i++)
        {
            helperDFS(heights, m, n, visited, 1, 0, i, -1);
        }
        // First Col
        for (i = 0; i < m; i++)
        {
            helperDFS(heights, m, n, visited, 1, i, 0, -1);
        }

        // Atlantic

        // Last row
        for (i = 0; i < n; i++)
        {
            helperDFS(heights, m, n, visited, 2, m - 1, i, -1);
        }
        // Last Col
        for (i = 0; i < m; i++)
        {
            helperDFS(heights, m, n, visited, 2, i, n - 1, -1);
        }

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (visited[i][j] == 3)
                    output.add(List.of(i, j));
            }
        }

        return output;
    }
}
