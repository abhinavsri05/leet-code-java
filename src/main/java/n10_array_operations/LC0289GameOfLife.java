package n10_array_operations;

public class LC0289GameOfLife
{
    private final int[][] directions= {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };
    private int getNeighboringState(int[][] grid, int m, int n, int r, int c)
    {
        // Dead 0, 3
        // Live 1, 2
        // 1 -> 0 = 2:
        // 0 -> 1 = 3
        int sum = 0;

        for (int[] dir: directions)
        {
            if (r + dir[0] < 0 || r + dir[0] >= m || c + dir[1] < 0 || c + dir[1] >= n)
                continue;
            if (grid[r + dir[0]][c + dir[1]] == 1 || grid[r + dir[0]][c + dir[1]] == 2) sum++;
        }
        return sum;

    }
    public void gameOfLife(int[][] board)
    {
        int m = board.length;
        int n = board[0].length;

        int i, j;
        int neighbor;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                neighbor = getNeighboringState(board, m, n, i, j);
                if (board[i][j] == 0)
                {
                    if (neighbor == 3) board[i][j] = 3;
                }
                else
                {
                    if (neighbor < 2) board[i][j] = 2;
                    if (neighbor > 3) board[i][j] = 2;
                }

            }
        }

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                board[i][j] %= 2;
            }
        }
    }
}
