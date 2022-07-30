package n03_graphs;
// This problem is basically finding the largest connected component of an undirected graph

import java.util.Stack;

public class LC0695MaxAreaofIsland {
//    private int tempCount = 0;
//
//    // Using visited
//    private void explore(int[][] grid, int sr, int sc, boolean[][] visited)
//    {
//
//        if (grid[sr][sc] != 1 || visited[sr][sc])
//            return;
//        visited[sr][sc] = true;
//        tempCount++;
//        // up
//        if (sr - 1 >= 0)
//        {
//            explore(grid, sr - 1, sc, visited);
//        }
//        //down
//        if (sr + 1 < grid.length)
//        {
//            explore(grid, sr + 1, sc, visited);
//        }
//        //right
//        if (sc - 1 >= 0)
//        {
//            explore(grid, sr, sc - 1, visited);
//        }
//
//        //left
//        if (sc + 1 < grid[0].length)
//        {
//            explore(grid, sr, sc + 1, visited);
//        }
//
//    }

//    public int maxAreaOfIsland(int[][] grid)
//    {
//        int r = grid.length;
//        int c = grid[0].length;
//        int i, j;
//        boolean[][] visited = new boolean[r][c];
//        int maxSCCSize = 0;
//
//        for (i = 0; i < r; i++)
//        {
//            for (j = 0; j < c; j++)
//            {
//                if (!visited[i][j] && grid[i][j] == 1)
//                {
//                    this.tempCount = 0;
//                    explore(grid, i, j, visited);
//                    maxSCCSize = Math.max(maxSCCSize, this.tempCount);
//                }
//            }
//        }
//        return maxSCCSize;
//    }

    // Updating original array values to avoid creating visited array and reducing function call by checking for value == 1.
    // This is not a good way to do
//    private void explore(int[][] grid, int sr, int sc)
//    {
//
//        grid[sr][sc] = 0;
//        tempCount++;
//        // up
//        if (sr - 1 >= 0 && grid[sr - 1][sc] == 1)
//        {
//            explore(grid, sr - 1, sc);
//        }
//        //down
//        if (sr + 1 < grid.length && grid[sr + 1][sc] == 1)
//        {
//            explore(grid, sr + 1, sc);
//        }
//        //right
//        if (sc - 1 >= 0 && grid[sr][sc - 1] == 1)
//        {
//            explore(grid, sr, sc - 1);
//        }
//
//        //left
//        if (sc + 1 < grid[0].length && grid[sr][sc + 1] == 1)
//        {
//            explore(grid, sr, sc + 1);
//        }
//
//    }
//
//    public int maxAreaOfIsland(int[][] grid)
//    {
//        int r = grid.length;
//        int c = grid[0].length;
//        int i, j;
//        int maxSCCSize = 0;
//
//        for (i = 0; i < r; i++)
//        {
//            for (j = 0; j < c; j++)
//            {
//                if (grid[i][j] == 1)
//                {
//                    this.tempCount = 0;
//                    explore(grid, i, j);
//                    maxSCCSize = Math.max(maxSCCSize, this.tempCount);
//                }
//            }
//        }
//        return maxSCCSize;
//    }

    // Without using a private instance variable
//    private int dfsExplore(int[][] grid, int sr, int sc, boolean[][] visited)
//    {
//
//        if (grid[sr][sc] != 1 || visited[sr][sc])
//            return 0;
//
//        visited[sr][sc] = true;
//
//        int count = 1;
//        // up
//        if (sr - 1 >= 0)
//            count += dfsExplore(grid, sr - 1, sc, visited);
//
//        //down
//        if (sr + 1 < grid.length)
//            count += dfsExplore(grid, sr + 1, sc, visited);
//
//        //right
//        if (sc - 1 >= 0)
//            count += dfsExplore(grid, sr, sc - 1, visited);
//
//        //left
//        if (sc + 1 < grid[0].length)
//            count += dfsExplore(grid, sr, sc + 1, visited);
//
//        return count;
//
//    }
//
//    public int maxAreaOfIsland(int[][] grid)
//    {
//        int r = grid.length;
//        int c = grid[0].length;
//        int i, j;
//        boolean[][] visited = new boolean[r][c];  // gets initialized to false by default
//        int maxCCSize = 0;
//
//        for (i = 0; i < r; i++)
//            for (j = 0; j < c; j++)
//                if (!visited[i][j] && grid[i][j] == 1)
//                    maxCCSize = Math.max(maxCCSize, dfsExplore(grid, i, j, visited));
//
//        return maxCCSize;
//    }

    // Without using recursion (not sure why but thi si staking longer than recursion.
    // Can you Deque instead of Stack. Deque is an interface, use LinedList class that implements Deque.
    // Deque does not has empty method instead it has size.

    /*
    private static int dfsExplore(Stack<int[]> stack, int[][] grid, int sr, int sc, boolean[][] visited)
    {

        stack.push(new int[]{sr, sc});
        int[] coordinate;
        int r, c;
        int count = 0;

        while (!stack.empty())
        {
            coordinate = stack.pop();
            r = coordinate[0];
            c = coordinate[1];

            if (grid[r][c] != 1 || visited[r][c])
                continue;

            visited[r][c] = true;
            count++;

            // up
            if (r - 1 >= 0)
                stack.push(new int[]{r - 1, c});

            //down
            if (r + 1 < grid.length)
                stack.push(new int[]{r + 1, c});

            //right
            if (c - 1 >= 0)
                stack.push(new int[]{r, c - 1});

            //left
            if (c + 1 < grid[0].length)
                stack.push(new int[]{r, c + 1});
        }

        return count;

    }

    public static int maxAreaOfIsland(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        int i, j;
        boolean[][] visited = new boolean[r][c];  // gets initialized to false by default
        int maxCCSize = 0;
        Stack<int[]> stack = new Stack<>();

        for (i = 0; i < r; i++)
            for (j = 0; j < c; j++)
                if (!visited[i][j] && grid[i][j] == 1)
                    maxCCSize = Math.max(maxCCSize, dfsExplore(stack, grid, i, j, visited));

        return maxCCSize;
    }
     */

    private static final int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private int dfs(int[][] grid, int row, int col)
    {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1)
            return 0;
        grid[row][col] = 2;
        int area = 1;

        for (int[] dir : directions)
            area += dfs(grid, row + dir[0], col + dir[1]);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid)
    {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1)
                {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }
}
