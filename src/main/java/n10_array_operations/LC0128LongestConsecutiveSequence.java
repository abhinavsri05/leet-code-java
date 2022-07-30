package n10_array_operations;

import java.util.HashSet;

public class LC0128LongestConsecutiveSequence
{
    public int longestConsecutive(int[] nums)
    {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num: nums)
            numsSet.add(num);

        int longCons = 0;
        int currCon = 0;
        int lookFor;

        for (int num : nums)
        {
            if (!numsSet.contains(num + 1))
            {
                // Count streak only when max element found
                currCon = 1;
                lookFor = num - 1;
                while (numsSet.contains(lookFor))
                {
                    currCon++;
                    lookFor--;
                }
            }

            longCons = Math.max(longCons, currCon);
        }

        return longCons;
    }
}
