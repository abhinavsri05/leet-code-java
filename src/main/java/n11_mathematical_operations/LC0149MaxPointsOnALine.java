package n11_mathematical_operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC0149MaxPointsOnALine {
    private List<Double> getLine(int x1, int y1, int x2, int y2)
    {
        List<Double> line = new ArrayList<>();
        double slope = y2 == y1 ? 0.0d : (x2 == x1 ? Double.POSITIVE_INFINITY : (y2 - y1) * 1.0d / (x2 - x1));
        double intercept = slope == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : y1 - slope * x1;
        line.add(slope);
        line.add(intercept);
        return line;
    }

    public int maxPoints1(int[][] points)
    {
        HashMap<List<Double>, Integer> map = new HashMap<>();
        HashSet<List<Double>> checked = new HashSet<>();
        HashMap<Integer, Integer> infinitySlope = new HashMap<>();

        int i, j;
        int n = points.length;
        int maxCount = 0;
        int count = 0;

        for (i = 0; i < n - 1; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                List<Double> line = getLine(points[i][0], points[i][1],
                        points[j][0], points[j][1]);

                // System.out.println("(" + points[i][0] + ", " +  points[i][1] + ") and (" + points[j][0] + ", " + points[j][1] + ") -> y = " + line.get(0) + " * x + " + line.get(1));

                List<Double> checkedFor = new ArrayList<>();
                checkedFor.add(points[j][0] * 1.0d);
                checkedFor.add(points[j][1] * 1.0d);
                checkedFor.add(line.get(0));
                checkedFor.add(line.get(1));

                if (checked.contains(checkedFor)) continue;

                if (map.containsKey(line))
                {
                    if (line.get(0) == Double.POSITIVE_INFINITY)
                    {
                        if (infinitySlope.containsKey(points[i][0]))
                        {
                            count = infinitySlope.get(points[i][0]) + 1;
                            infinitySlope.put(points[i][0], count);
                        }
                    }
                    else
                    {
                        count = map.get(line) + 1;
                    }
                }
                else
                {
                    count = 1;
                    if (line.get(0) == Double.POSITIVE_INFINITY)
                    {
                        infinitySlope.put(points[i][0], count);
                    }

                }
                map.put(line, count);
                maxCount = Math.max(maxCount, count);
                checked.add(checkedFor);

            }
        }
        return maxCount + 1;
    }

    // Solution 2: From best solution submitted

    private boolean checkSameLine(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        // return (y3 - y1) == (y2 - y1) * (x3 - x1) / (x2 - x1);
        return (y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1); // To avoid division by 0
    }

    public int maxPoints(int[][] points)
    {
        int n = points.length;
        int i, j, k;
        int count = 0;
        int max = n <= 2 ? n : 1; // Two points are always on a line. Single point too. Any more than two will be taken care of in the loops
        int x1, x2, x3, y1, y2, y3;

        // We do not need to track if a line has already been counted for since if we recount a line,
        // at least one point will not be included, that will result in a lower count.

        for (i = 0; i < n - 2; i++)
        {
            x1 = points[i][0];
            y1 = points[i][1];
            for (j = i + 1; j < n - 1; j++)
            {
                x2 = points[j][0];
                y2 = points[j][1];
                count = 2;
                for (k = j + 1; k < n; k++)
                {
                    x3 = points[k][0];
                    y3 = points[k][1];
                    if (checkSameLine(x1, y1, x2, y2, x3, y3)) count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
