package n10_array_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC1338ReduceArraySizeToTheHalf
{
    public int minSetSize(int[] arr)
    {
        int n = arr.length;

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num: arr)
        {
            Integer ct = counts.getOrDefault(num, 0);
            counts.put(num, ct + 1);
        }

        List<Integer> countList = new ArrayList<>(counts.values());

        Collections.sort(countList, (i, j) -> j - i);

        int threshold = (int)Math.ceil(n / 2);
        int removed = 0;

        for (int num: countList)
        {
            if (threshold > 0)
            {
                removed++;
                threshold -= num;
            }
            else
                break;
        }
        return removed;
    }
}
