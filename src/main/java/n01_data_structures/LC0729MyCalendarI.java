package n01_data_structures;

import java.util.TreeSet;

public class LC0729MyCalendarI
{
    // Using ordered set
    private TreeSet<int[]> ts;

    public LC0729MyCalendarI()
    {
        ts = new TreeSet<>((i, j) -> i[0] - j[0]);
    }

    public boolean book(int start, int end)
    {
        int prevEnd = -1;
        for (int[] e: ts)
        {
            // if ((end > e[0] && end <= e[1]) || (start < e[1] && start >= e[0]) || (start >= e[0] && end <= e[1]) || (start <= e[0] && end >= e[1]))
            //     return false;
            if (end > e[0] && start < e[1])
                return false;

            if (start >= prevEnd && end <= e[0])
                break; // If the new entry is valid then break instead of checking remaining entries

            prevEnd = e[1];
        }

        ts.add(new int[]{start, end});

        return true;
    }
}
