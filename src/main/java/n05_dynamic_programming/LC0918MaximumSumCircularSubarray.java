package n05_dynamic_programming;

public class LC0918MaximumSumCircularSubarray
{
    // Following does not work
    /*
    This solution may include negative value
     */
    public int maxSubarraySumCircular(int[] nums)
    {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i;

        for (int num: nums)
        {
            sum = num + Math.max(0, sum);
            maxSum = Math.max(maxSum, sum);
        }
        if (maxSum == sum)
        {
            for (int num: nums)
            {
                sum = num + Math.max(0, sum);
                maxSum = Math.max(maxSum, sum);
                if (sum < maxSum) break;
            }
        }
        return maxSum;
    }
    // This too does not work-
    public int maxSubarraySumCircular2(int[] nums)
    {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i;
        int inclStart = Integer.MIN_VALUE;
        int inclEnd = 0;

        for (int num: nums)
        {
            sum = num + Math.max(0, sum);
            maxSum = Math.max(maxSum, sum);
            if (inclStart == Integer.MIN_VALUE && sum == maxSum)
                inclStart = sum;
        }
        inclEnd = sum;

        return Math.max(maxSum, inclStart + inclEnd);
    }

    public int maxSubarraySumCircular3(int[] nums)
    {
        int sum1 = 0;
        int sum2 = 0;
        int maxSum = Integer.MIN_VALUE;
        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num: nums)
        {
            totalSum += num;
            sum1 = num + Math.max(0, sum1);
            maxSum = Math.max(maxSum, sum1);
            sum2 = num + Math.min(0, sum2);
            minSum = Math.min(minSum, sum2);

        }
        if (maxSum < 0) return maxSum; // If maxSum is negative then minSum will be 0 since sum2 was initialized with 0. This will happen when al elements are negative. maxSum will point to the maximum element (subarray size  = 1)
        return Math.max(maxSum, totalSum - minSum);
    }
}
