package leet_code_contests.weekly.wc290_20220423;

public class LC2250CountNumberOfRectanglesContainingEachPoint
{
    // Brute Force - not accepted
    /*
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        // Arrays.sort(rectangles, (i, j) -> {
        //     if (i[0] != j[0]) return i[0] - j[0];
        //     else return i[1] - j[1];
        //     });

        int[] output = new int[points.length];
        int i, j;

        for (i = 0; i < points.length; i++)
        {
            for (j = 0; j < rectangles.length; j++)
            {
                if (points[i][0] <= rectangles[j][0] && points[i][1] <= rectangles[j][1])
                    output[i]++;
            }
        }

        return output;

    }
     */
}
