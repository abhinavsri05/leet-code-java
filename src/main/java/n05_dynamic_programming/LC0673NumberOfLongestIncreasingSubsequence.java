package n05_dynamic_programming;

public class LC0673NumberOfLongestIncreasingSubsequence
{
    // My attempt - not working
    /*
    public int findNumberOfLIS(int[] nums)
    {
        int maxLISLength = 1;
        int count = nums.length;
        int n = nums.length;

        int[]dp = new int[n + 1];
        int[] ways = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(ways, 1);
        dp[0] = 0;

        int i, j;

        for (i = 1; i <= n; i++)
        {
            for (j = 1; j < i; j++)
            {
                // System.out.println("i; " + i + ", j: " + j);
                if (nums[j - 1] < nums[i - 1])
                {
                    int val = Math.max(dp[i], dp[j] + 1);
                    // System.out.println("dp[" + i + "] = " + dp[i]);
                    // System.out.println("Old MaxLength: " + maxLISLength);
                    if (val == dp[i] && val == maxLISLength)
                    {
                        ways[i - 1]++;
                        count += ways[i - 1];

                        // System.out.println("Count Updated: " + count);
                    }
                    else
                    {
                        if (val == maxLISLength)
                        {
                            // count = 1;
                            ways[i - 1] = 1;
                        }
                    }
                    if (val > maxLISLength)
                    {
                        maxLISLength = val;
                        count = 1;
                        // System.out.println("Count Reset: " + count);
                        ways[i - 1] = 1;
                    }
                    dp[i] = val;
                    // System.out.println("New MaxLength: " + maxLISLength);
                }
            }
        }

        System.out.println(Arrays.toString(ways));
        // System.out.println(Arrays.toString(dp));

        // System.out.println(maxLISLength);
        return count;
    }
     */
}
