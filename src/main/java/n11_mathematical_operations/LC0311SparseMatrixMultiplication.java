package n11_mathematical_operations;

public class LC0311SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;

        int[][] mult = new int[m][n];

        int x, y, z;

        for (x = 0; x < m; x++)
        {
            for (y = 0; y < k; y++)
            {
                if (mat1[x][y] == 0) continue;
                for (z = 0; z < n; z++)
                    mult[x][z] += mat1[x][y] * mat2[y][z];
            }
        }
        return mult;
    }
}
