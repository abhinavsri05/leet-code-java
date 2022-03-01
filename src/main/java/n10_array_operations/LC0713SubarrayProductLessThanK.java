package n10_array_operations;

public class LC0713SubarrayProductLessThanK {

    //First Attempt - Did not work due to high memory usage - used DP

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];
        int i, j;
        int count = 0;


        for (i = 0; i < nums.length; i++)
        {
            for (j = i; j < nums.length; j++)
            {
                if (j != i )
                    dp[i][j] = dp[i][j - 1] * nums[j];
                else
                    dp[i][j] = nums[i];

                if (dp[i][j] < k)
                {
                    count++;
                }
                else
                    break; // will overflow without this and result in negative value causing incorrect count.
            }
        }
        return count;
    }

    // Another O(n^2) with O(1) space.
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int prod;
        int i, j;
        int count = 0;

        for (i = 0; i < nums.length; i++)
        {
            prod = 1;
            for (j = i; j < nums.length; j++)
            {
                if (j != i )
                    prod *= nums[j];
                else
                    prod = nums[i];

                if (prod < k)
                {
                    count++;
                }
                else
                    break;
            }
        }
        return count;
    }

    // O(n) time and O(1) space

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int count = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < nums.length; right++)
        {
            prod *= nums[right];
            while (prod >= k  && left <= right)
                prod /= nums[left++];
            count += right - left + 1;
        }
        return count;
    }
}
