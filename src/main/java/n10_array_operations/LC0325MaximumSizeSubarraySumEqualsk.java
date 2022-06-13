package n10_array_operations;

import java.util.HashMap;

public class LC0325MaximumSizeSubarraySumEqualsk
{
    public int maxSubArrayLen(int[] nums, int k)
    {
        int[] pSum = new int[nums.length + 1];
        int maxSize = 0;
        HashMap<Integer, Integer> sumIdx = new HashMap<>();
        pSum[0] = 0;
        sumIdx.put(0, 0);

        for (int i = 1; i <= nums.length; i++)
        {
            pSum[i] = pSum[i - 1] + nums[i - 1];
            maxSize = Math.max(maxSize, i - sumIdx.getOrDefault(pSum[i] - k, nums.length)); // Default value will result in negative or 0 value.
            if (sumIdx.containsKey(pSum[i])) continue; // No need to update if key already exists since we need ot find subarray of max length
            sumIdx.put(pSum[i], i);
        }

        return maxSize;
    }
}
