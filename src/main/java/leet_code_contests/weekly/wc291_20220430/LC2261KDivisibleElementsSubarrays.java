package leet_code_contests.weekly.wc291_20220430;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC2261KDivisibleElementsSubarrays
{
    public int countDistinct(int[] nums, int k, int p)
    {
        HashSet<List<Integer>> seen = new HashSet<>();

        int i, j;
        int n = nums.length;
        int c;
        List<Integer> list;

        for (i = 0; i < n; i++)
        {
            c = 0;
            list = new LinkedList<>();
            for (j = i; j < n; j++)
            {
                if (nums[j] % p == 0)
                    c++;
                if (c <= k)
                {
                    list.add(nums[j]);
                    seen.add(new LinkedList(list));
                }
                else
                    break;

            }
        }

        return seen.size();
    }
}
