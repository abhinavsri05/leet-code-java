package leet_code_contests.weekly.wc294_20220521;

import java.util.Arrays;

public class LC2279MaximumBagsWithFullCapacityOfRocks
{
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks)
    {
        int n = capacity.length;
        int[] remain = new int[n];
        int i;
        int count = 0;
        for (i = 0; i < n; i++)
        {
            remain[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remain);

        for (i = 0; i < n; i++)
        {
            if (remain[i] == 0)
            {
                count++;
                continue;
            }
            if (additionalRocks >= remain[i])
            {
                count++;
                additionalRocks -= remain[i];
            }
            else
                break;

        }

        return count;

    }
}
