package n10_array_operations;

import java.util.HashMap;

public class LC1679MaxNumberOfKSumPairs
{
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int freq;
        int res = 0;
        int rem1, rem2;

        // Add to HashMap

        for (int num: nums)
        {
            freq = counts.getOrDefault(num, 0);
            counts.put(num, freq + 1);
        }

        for (int num: nums)
        {
            rem1 = counts.get(num);
            rem2 = counts.getOrDefault(k - num, 0);
            if (num == k - num && rem1 < 2) continue;
            if (rem1 > 0 && rem2 > 0)
            {
                res++;
                if (num == k - num)
                {
                    counts.put(num, rem1 - 2);
                }
                else
                {
                    counts.put(num, rem1 - 1);
                    counts.put(k - num, rem2 - 1);
                }
            }
        }

        return res;

    }
}
