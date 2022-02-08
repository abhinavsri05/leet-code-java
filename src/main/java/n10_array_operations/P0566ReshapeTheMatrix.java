package n10_array_operations;

public class P0566ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || mat.length * mat[0].length != r * c)
            return mat;
        int[][] reshaped = new int[r][c];

        for (int i = 0; i < r * c; i++)
        {
            reshaped[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        }

        return reshaped;
    }
}
