package n10_array_operations;

public class LC0304RangeSumQuery2DImmutable
{
    private int[][] prefixSum;

    public LC0304RangeSumQuery2DImmutable(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int i, j;
        prefixSum = new int[m][n];

        for (i = 0; i < n; i++)
            prefixSum[0][i] = matrix[0][i];

        for (i = 1; i < m; i++)
            for (j = 0; j < n; j++)
                prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int i, j;
        int sum = 0;
        for (i = col1; i <= col2; i++)
        {
            if (row1 == 0)
                sum += prefixSum[row2][i];
            else
                sum += (prefixSum[row2][i] - prefixSum[row1 - 1][i]);
        }
        return sum;
    }
}
