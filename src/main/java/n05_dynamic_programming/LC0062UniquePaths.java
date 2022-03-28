package n05_dynamic_programming;

public class LC0062UniquePaths
{
    public int uniquePaths1(int m, int n) {
        int[][] moves = new int[m][n];
        moves[0][0] = 1;
        int i, j;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (moves[i][j] > 0)
                {
                    if (i + 1 < m)
                        moves[i + 1][j] += moves[i][j];
                    if (j + 1 < n)
                        moves[i][j + 1] += moves[i][j];
                }
            }
        }

        return moves[m - 1][n - 1];
    }

    // Attempt 2: First row and first column has only one way of going to
    public int uniquePaths(int m, int n) {
        int[][] moves = new int[m][n];
        int i, j;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (i == 0 || j == 0)
                    moves[i][j] = 1;
                else
                    moves[i][j] = moves[i - 1][j] + moves[i][j - 1];
            }
        }

        return moves[m - 1][n - 1];
    }
}
