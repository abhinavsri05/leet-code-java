package n05_dynamic_programming;

import java.util.Arrays;

public class LC0354RussianDollEnvelopes
{
    /*
    This problem is asking for LIS in two dimensions, width and height. Sorting the width reduces the problem by one dimension. If width is strictly increasing,
    the problem is equivalent to finding LIS in only the height dimension. However, when there is a tie in width, a strictly increasing sequence in height
    may not be a correct solution. For example, [[3,3] cannot fit in [3,4]]. Sorting height in descending order when there is a tie prevents
    such a sequence to be included in the solution.

    The same idea can be applied to problems of higher dimensions. For example, box fitting is three dimensions, width, height, and length. Sorting width
    ascending and height descending reduces the problem by one dimension. Finding the LIS by height further reduces the problem by another dimension.
    When find LIS based on only length, it becomes a standard LIS problem.
     */
    public int lengthLISBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    private int lengthLIS(int[] nums)
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

    public int maxEnvelopes(int[][] envelopes)
    {
        int n = envelopes.length;
        Arrays.sort(envelopes, (i, j) ->
        {
            if (i[0] == j[0])
                return j[1] - i[1]; // Reverse on second dimension. This is done so that if first dimension is same then second dimension be in reverse order.
            else
                return i[0] - j[0];
        });

        int[] heights = new int[n];

        for (int i = 0; i < n; i++)
        {
            heights[i] = envelopes[i][1];
        }

        return lengthLISBinarySearch(heights);
    }
}
