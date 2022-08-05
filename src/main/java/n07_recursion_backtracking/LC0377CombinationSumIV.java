package n07_recursion_backtracking;

import java.util.Arrays;

public class LC0377CombinationSumIV
{
    // Backtracking - not optimal
    /*
    public int combinationSum4(int[] nums, int target)
    {
        if (target < 0) return 0;
        if (target == 0) return 1;

        int count = 0;

        for (int n: nums)
        {
            count += combinationSum4(nums, target - n);
        }

        return count;
    }
    */

    // Backtracking and some memoization
    public int helper(int[] nums, int[] memo, int target)
    {
        if (target < 0) return 0;
        if (memo[target] >= 0) return memo[target];
        if (target == 0) return 1;

        int count = 0;

        for (int n: nums)
        {
            count += helper(nums, memo, target - n);
        }
        memo[target] = count;
        return count;
    }

    public int combinationSum4(int[] nums, int target)
    {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1); // 0 is a valid value

        return helper(nums, memo, target);

    }

    /*
    Follow up: If there are negative values then we would need to limit the max number of elements in the combination sum.
     */
}
