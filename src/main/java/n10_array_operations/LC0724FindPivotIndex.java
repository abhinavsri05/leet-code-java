package n10_array_operations;

public class LC0724FindPivotIndex
{
    public int pivotIndex(int[] nums)
    {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        int i;
        for (i = 1; i <= n; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (i = 1; i < n; i++)
        {
            if (prefixSum[i - 1] == prefixSum[n] - prefixSum[i]) return i - 1;
        }
        if (prefixSum[n] - nums[n - 1] == 0) return n - 1;
        return -1;
    }
}
