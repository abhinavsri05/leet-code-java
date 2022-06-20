package leet_code_contests.weekly.wc298_20220618;

public class LC2310SumOfNumbersWithUnitsDigitK
{
    private final static int[][] cyclicity = new int[][]{
            {0},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
            {2, 4, 6, 8, 0},
            {3, 6, 9, 2, 5, 8, 1, 4, 7, 0},
            {4, 8, 2, 6, 0},
            {5, 0},
            {6, 2, 8, 4, 0},
            {7, 4, 1, 8, 5, 2, 9, 6, 3, 0},
            {8, 6, 4, 2, 0},
            {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
    };

    public int minimumNumbers(int num, int k)
    {
        if (num == 0) return 0;
        if (k > num) return -1;
        if (k == num) return 1;

        for (int i = 0; i < cyclicity[k].length; i++)
            if (cyclicity[k][i] == num % 10 && num >= k * (i + 1))
                return i + 1;

        return -1;
    }
}
