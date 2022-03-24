package n03_graphs;

public class LC0130SurroundedRegion {
    // Attempt 1: Does not work
    /*
    Test:
    [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    [["X"]]
    [["O","O"],["O","O"]]
    [["X","X","X"],["X","O","X"],["X","X","X"]]
    [["O","X","X","O","X"],["X","O","O","X","O"],["X","O","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]

    Below is same input but on different lines for visualization

    [["X","X","X","X"],
     ["X","O","O","X"],
     ["X","X","O","X"],
     ["X","O","X","X"]]

    [["X"]]

    [["O","O"],
     ["O","O"]]

    [["X","X","X"],
     ["X","O","X"],
      ["X","X","X"]]

    [["O","X","X","O","X"],
     ["X","O","O","X","O"],
     ["X","O","X","O","X"],
     ["O","X","O","O","O"],
     ["X","X","O","X","O"]]


    private static final int[][] directions = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
    };

    private boolean dfs(int r, int c, char[][] board)
    {
        int m = board.length;
        int n = board[0].length;

        if (r == 0 || c == 0 || r == m - 1 || c == n - 1) return false;
        // board[r][c] = 'X';

        int newR, newC;
        boolean ret = true;


        for (int[] d: directions)
        {
            newR = r + d[0];
            newC = c + d[1];

            if (newR >= 0 && newR < m && newC >= 0 && newC < n && board[newR][newC] == 'O')
            {
                board[newR][newC] = 'N';
                ret = dfs(newR, newC, board);
                if (ret)
                    board[newR][newC] = 'X';
                else
                {
                    board[newR][newC] = 'O';

                }

            }
        }
        return ret;
    }

    public void solve(char[][] board)
    {
        int m = board.length;
        int n = board[0].length;
        boolean ret;
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (!(r == 0 || c == 0 || r == m - 1 || c == n - 1) && board[r][c] == 'O')
                {
                    board[r][c] = 'N';
                    ret = dfs(r, c, board);
                    if (ret)
                        board[r][c] = 'X';
                    else
                        board[r][c] = 'O';
                }
            }
        }

    }
         */
    // Attempt 2: Using hint and discussion
    private static final int[][] directions = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
    };

    int m, n;
    char[][] board;

    private void dfs(int r, int c)
    {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O')
            return;

        board[r][c] = 'N';

        for (int[] d: directions)
        {
            dfs(r + d[0], c + d[1]);
        }


    }

    public void solve(char[][] board)
    {
        // Start from the corner O's. Run DFS, all O's conected to these O's will not be flipped. All others will be.
        this.board = board;
        m = board.length;
        n = board[0].length;
        boolean ret;
        int r, c;

        // First and last row
        for (c = 0; c < n; c++)
        {
            if (board[0][c] == 'O')
                dfs(0, c);
            if (board[m - 1][c] == 'O')
                dfs(m - 1, c);
        }

        // First and last column
        for (r = 0; r < m; r++)
        {
            if (board[r][0] == 'O')
                dfs(r, 0);
            if (board[r][n - 1] == 'O')
                dfs(r, n - 1);
        }

        for (r = 0; r < m; r++)
        {
            for (c = 0; c < n; c++)
            {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'N') board[r][c] = 'O';
                // Note that the order of the two conditions above cannot be swapped

            }
        }

    }
}
