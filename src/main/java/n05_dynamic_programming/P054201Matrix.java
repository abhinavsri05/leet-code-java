package n05_dynamic_programming;

public class P054201Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] output = new int[m][n];
        int maxValue = 99999;

        int i, j, up , down, left, right, minOfTwo;

        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                    output[i][j] = 0;
                else
                    output[i][j] = maxValue;
            }
        }


        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {
                up = i - 1 >= 0 ? output[i - 1][j] + 1: maxValue;
                left = j - 1 >= 0 ? output[i][j - 1] + 1: maxValue;
                minOfTwo = Math.min(up, left);
                output[i][j] = Math.min(output[i][j], minOfTwo);
            }
        }

        for (i = m - 1; i >= 0; i--)
        {
            for (j = n - 1; j >= 0; j--)
            {
                down = i + 1 < m ? output[i + 1][j] + 1: maxValue;
                right = j + 1 < n ? output[i][j + 1] + 1: maxValue;
                minOfTwo = Math.min(down, right);
                output[i][j] = Math.min(output[i][j], minOfTwo);
            }
        }

        return output;
    }
}
