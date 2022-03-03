package n05_dynamic_programming;

public class LC0413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int i = 0;
        int count = 0;
        for (i = 2; i < nums.length; i++)
        {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) // Identifies a sequence of length 3
            {
                dp[i] = 1 + dp[i - 1];
                count += dp[i];
            }
        }
        return count;
    }
}
