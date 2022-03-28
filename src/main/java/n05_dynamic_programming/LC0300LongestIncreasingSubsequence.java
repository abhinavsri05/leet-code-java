package n05_dynamic_programming;

public class LC0300LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1; // Each element is a LIS so minimum length is 1
        int i, j;

        for (i = 0; i < n; i++)
        {
            dp[i] = 1;
            for (j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}
