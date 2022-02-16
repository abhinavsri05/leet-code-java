package n02_divide_and_conquer;

public class LC0074SearchIn2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix[0].length;
        int start = 0, end = matrix.length * n - 1;
        int mid;
        int x, y;

        while (start <= end)
        {
            mid = (start + end) / 2;
            x = mid / n;
            y = mid % n;
            if (matrix[x][y] == target)
                return true;

            if (matrix[x][y] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }

        return false;

    }
}
