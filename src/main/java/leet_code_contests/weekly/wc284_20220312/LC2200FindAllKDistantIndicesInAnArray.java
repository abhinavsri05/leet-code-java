package leet_code_contests.weekly.wc284_20220312;

import java.util.*;

public class LC2200FindAllKDistantIndicesInAnArray {
    // Contest Submission: Takes over 150ms
    public List<Integer> findKDistantIndices1(int[] nums, int key, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int i, j;

        for (i = 0; i < n; i++)
        {
            if (nums[i] == key)
            {
                for (j = i - k; j <= i + k; j++)
                {
                    if (j >= 0 && j < n)
                        set.add(j);
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;

    }

    // Attempt 2 (Takes <= 2ms)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k)    {
        List<Integer> list = new LinkedList<>();
        int n = nums.length;
        int i, j;
        int last = -1;

        for (i = 0; i < n; i++)
        {
            if (nums[i] == key)
            {
                for (j = Math.max(last + 1, i - k); j <= Math.min(i + k, n - 1); j++)
                {
                    list.add(j);
                }
                last = j - 1;
            }
        }

        return list;

    }
}
