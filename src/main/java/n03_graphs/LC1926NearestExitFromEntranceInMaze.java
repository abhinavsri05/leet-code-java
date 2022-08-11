package n03_graphs;

import java.util.ArrayDeque;

public class LC1926NearestExitFromEntranceInMaze
{
    private static final int[][] dirs = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };
    public int nearestExit(char[][] maze, int[] entrance)
    {
        int m = maze.length;
        int n = maze[0].length;

        int i, j;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = 'x';

        int[] top;
        int r, c;

        while (q.size() > 0)
        {
            top = q.poll();

            for(int[] d: dirs)
            {
                r = top[0] + d[0];
                c = top[1] + d[1];

                if (r < 0 || r >= m || c < 0 || c >= n)
                {
                    if (top[2] == 0)  // Entrance is not an exit
                        continue;
                    else
                        return top[2];
                }
                if (maze[r][c] != '.') continue;
                q.add(new int[]{r, c, top[2] + 1});
                maze[r][c] = 'x';
            }
        }

        return -1;
    }
}
