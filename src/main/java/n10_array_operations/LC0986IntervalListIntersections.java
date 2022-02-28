package n10_array_operations;

import java.util.ArrayList;

public class LC0986IntervalListIntersections {
    // First attempt - too many conditions
    public int[][] intervalIntersection1(int[][] firstList, int[][] secondList)
    {
        int p1 = 0;
        int p2 = 0;
        int s, e;
        boolean first, second;

        ArrayList<int[]> output = new ArrayList<>();

        while (p1 < firstList.length && p2 < secondList.length)
        {
            first = false;
            second = false;
            s = -1;
            e = -1;

            if (firstList[p1][0] >= secondList[p2][0] && firstList[p1][0] <= secondList[p2][1])
            {
                s = firstList[p1][0];
            }
            else if (secondList[p2][0] >= firstList[p1][0] && secondList[p2][0] <= firstList[p1][1])
            {
                s = secondList[p2][0];
            }

            if (firstList[p1][1] >= secondList[p2][0] && firstList[p1][1] <= secondList[p2][1])
            {
                e = firstList[p1][1];
                first = true;
            }
            if (secondList[p2][1] >= firstList[p1][0] && secondList[p2][1] <= firstList[p1][1])
            {
                e = secondList[p2][1];
                second = true;
            }

            if (first) p1++;
            if (second) p2++;
            if (first || second)
            {
                output.add(new int[]{s, e});
            }

            // When no overlap the one needs to moved forward
            if (!first && !second)
            {
                if (secondList[p2][1] < firstList[p1][0])
                    p2++;
                else
                    p1++;
            }

        }

        return output.toArray(new int[output.size()][]);
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList)
    {
        int p1 = 0;
        int p2 = 0;
        int s, e;

        ArrayList<int[]> output = new ArrayList<>();

        while (p1 < firstList.length && p2 < secondList.length)
        {
            s = Math.max(firstList[p1][0], secondList[p2][0]);
            e = Math.min(firstList[p1][1], secondList[p2][1]);

            if (s <= e)
                output.add(new int[]{s, e});

            if (firstList[p1][1] < secondList[p2][1])
                p1++;
            else
                p2++;
        }

        return output.toArray(new int[output.size()][]);
    }

}
