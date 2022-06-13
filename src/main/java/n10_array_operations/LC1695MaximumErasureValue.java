package n10_array_operations;

import java.util.HashMap;

public class LC1695MaximumErasureValue
{
    // Using HashMap
    public int maximumUniqueSubarray1(int[] nums)
    {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int value = 0;
        int maxValue = 0;
        int lt = 0, rt;
        int lastIndex;

        // Consider [lt, rt] subarray indices
        for (rt = 0; rt < nums.length; rt++)
        {
            if (seen.containsKey(nums[rt]))
            {
                maxValue = Math.max(maxValue, value);
                lastIndex = seen.get(nums[rt]);
                while (lt <= lastIndex)
                {
                    seen.remove(nums[lt]);
                    value -= nums[lt++];

                }
            }
            value += nums[rt];
            seen.put(nums[rt], rt);
        }

        return Math.max(maxValue, value);
    }

    // Using Array O(1) space
    public int maximumUniqueSubarray(int[] nums)
    {
        int[] seen = new int[10001]; // 0th index unused
        // seen array will contain actual index + 1 value to avoid initializing the array
        int value = 0;
        int maxValue = 0;
        int lt = 0, rt;
        int lastIndex;

        // Consider [lt, rt] subarray indices
        for (rt = 0; rt < nums.length; rt++)
        {
            if (seen[nums[rt]] > 0)
            {
                maxValue = Math.max(maxValue, value);
                lastIndex = seen[nums[rt]] - 1;
                while (lt <= lastIndex)
                {
                    seen[nums[lt]] = 0;
                    value -= nums[lt++];
                }
            }
            value += nums[rt];
            seen[nums[rt]] = rt + 1;
        }

        return Math.max(maxValue, value);
    }
}
