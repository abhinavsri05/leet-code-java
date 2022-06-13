package n10_array_operations;

public class LC0867TransposeMatrix
{
    public int[][] transpose(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transpose = new int[n][m];
        int i, j;

        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                transpose[j][i] = matrix[i][j];

        return transpose;
    }
}
