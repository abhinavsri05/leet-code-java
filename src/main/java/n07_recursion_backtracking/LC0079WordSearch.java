package n07_recursion_backtracking;

public class LC0079WordSearch {
    int[][] direction = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public boolean backtrack(char[][] board, char[] word, int m, int n, int wordLength, int r, int c, int l)
    {
        if (r < 0 || r >= m || c < 0 || c >= n || word[l] != board[r][c] || board[r][c] == '#') return false;

        if (l == wordLength - 1 && word[l] == board[r][c])
            return true;

        // No need to track the letter since if we reach this line then this character would be matching the original string
        board[r][c] = '#';

        for (int[] d: direction)
        {
            if (backtrack(board, word, m, n, wordLength, r + d[0], c + d[1], l + 1)) return true;
        }

        board[r][c] = word[l];

        return false;

    }

    public boolean exist(char[][] board, String word)
    {
        int len = word.length();

        char[] wordArray = word.toCharArray();

        int m = board.length;
        int n = board[0].length;
        int i, j;

        boolean ret = false;

        outer:
        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (board[i][j] == wordArray[0])
                {
                    ret = backtrack(board, wordArray, m, n, len, i, j, 0);
                    if (ret) break outer;
                }
            }
        }

        return ret;
    }
}
