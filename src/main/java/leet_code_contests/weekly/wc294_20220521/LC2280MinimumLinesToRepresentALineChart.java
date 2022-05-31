package leet_code_contests.weekly.wc294_20220521;

import java.util.Arrays;
import java.util.Comparator;

public class LC2280MinimumLinesToRepresentALineChart
{
    private boolean sameLine(int[] p1, int[] p2, int[] p3)
    {
        return (p3[1] - p1[1]) * (p2[0] - p1[0]) == (p2[1] - p1[1]) * (p3[0] - p1[0]);

    }
    public int minimumLines(int[][] stockPrices)
    {
        int points = stockPrices.length;
        if (points == 1) return 0;
        if (points <= 2) return 1;

        // Both these sort work the same
//        Arrays.sort(stockPrices, (i, j) -> i[0] - j[0]);
        Arrays.sort(stockPrices, Comparator.comparingInt(i -> i[0]));
        int lines = 1;

        int i;
        for (i = 2; i < points; i++)
        {
            if (!sameLine(stockPrices[i - 2], stockPrices[i - 1], stockPrices[i]))
                lines++;
        }

        return lines;

    }
}
