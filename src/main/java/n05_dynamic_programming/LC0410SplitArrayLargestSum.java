package n05_dynamic_programming;

public class LC0410SplitArrayLargestSum {
    private int getAnswer(Integer[][] memo, int[] prefixSum, int n, int start, int countSubArrays)
    {
        if (memo[start][countSubArrays - 1] != null)
            return memo[start][countSubArrays - 1];

        if (countSubArrays == 1)
            return prefixSum[n] - prefixSum[start];

        int minValue = Integer.MAX_VALUE;

        for (int i = start; i <= n - countSubArrays; i++)
        {
            int firstSplitSum = prefixSum[i + 1] - prefixSum[start];

            minValue = Math.min(minValue, Math.max(firstSplitSum, getAnswer(memo, prefixSum, n, i + 1, countSubArrays - 1)));

            if (firstSplitSum >= minValue)
                break;
        }

        return memo[start][countSubArrays - 1] = minValue;
    }

    public int splitArray(int[] nums, int m)
    {
        int[] prefixSum = new int[nums.length + 1];
        // ith index does not include nums[i]
        prefixSum[0] = 0;

        Integer[][] memo = new Integer[nums.length][m];
        // Not primitive type since that will require initialization to a negative value. This will initialize values to NULL

        int i;

        for (i = 1; i <= nums.length; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

        return getAnswer(memo, prefixSum, nums.length, 0, m);
    }
}
