package n05_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LC0118PascalsTriangle
{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        int i, j;

        List<Integer> current = new ArrayList<>(1);

        current.add(0, 1);

        triangle.add(0, current);

        for (i = 1; i < numRows; i++)
        {
            current = new ArrayList<>(i + 1);
            current.add(0, 1);

            for(j = 1; j < i; j++)
            {
                current.add(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }

            current.add(i, 1);
            triangle.add(i, current);
        }

        return triangle;
    }
}
