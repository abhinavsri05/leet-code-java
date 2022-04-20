package n10_array_operations;

public class LC0059SpiralMatrixII
{
    public int[][] generateMatrix(int n)
    {
        int c = 1, i;
        int[][] output = new int[n][n];
        int start = 0, end = n - 1;
        while (c <= n * n)
        {
            // first row
            for (i = start; i <= end && c <= n * n; i++)
                output[start][i] = c++;
            // last column
            for (i = start + 1; i <= end && c <= n * n; i++ )
                output[i][end] = c++;
            // last row
            for (i = end - 1; i >= start && c <= n * n; i--)
                output[end][i] = c++;
            // first column
            for (i = end - 1; i >= start + 1 && c <= n * n; i--)
                output[i][start] = c++;
            start++;
            end--;
        }
        return output;
    }
}
