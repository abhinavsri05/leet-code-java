package leet_code_contests.weekly.wc290_20220423;

import javafx.util.Pair;

import java.util.HashSet;

public class LC2249CountLatticePointsInsideACircle
{
    private boolean pointInCircle(int x, int y, int cx, int cy, int r)
    {
        return (cx - x) * (cx - x) + (cy - y) * (cy - y) <= r * r;
    }
    public int countLatticePoints(int[][] circles) {
        HashSet<Pair<Integer, Integer>> in = new HashSet<>();
        int i, j;

        for (int[] circle : circles)
        {
            for (i = circle[0] - circle[2]; i <= circle[0] + circle[2]; i++)
            {
                for (j = circle[1] - circle[2]; j <= circle[1] + circle[2]; j++)
                {
                    if (pointInCircle(i, j, circle[0], circle[1], circle[2]))
                        in.add(new Pair(i, j));
                }
            }

        }
        // for (int[] v: in)
        // {
        //     System.out.print(v[0] + "," + v[1] + " | ");
        // }
        return in.size();
    }
}
