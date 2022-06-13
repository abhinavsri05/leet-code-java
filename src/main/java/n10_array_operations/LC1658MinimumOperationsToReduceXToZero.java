package n10_array_operations;

public class LC1658MinimumOperationsToReduceXToZero {
    // Based on LC Solution # 1
    public int minOperations1(int[] nums, int x)
    {
        // This is a simpler implementation of LC# 325 but is simpler since this only caters to positive numbers
        if (x == 0) return 0;
        if (nums.length == 0) return -1;

        int sum = 0;
        int maxLength = -1;

        for (int num: nums)
            sum += num;

        int target = sum - x; // maximise the subarray with sum as target

        int lo = 0;
        int hi = 0;
        int runningSum = 0;

        for(; hi < nums.length; hi++)
        {
            runningSum += nums[hi];

            while (runningSum > target && lo <= hi)
                runningSum -= nums[lo++];

            if (runningSum == target)
                maxLength = Math.max(maxLength, hi - lo + 1);
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    // Based on LC Solution # 2
    public int minOperations(int[] nums, int x)
    {
        if (x == 0) return 0;
        if (nums.length == 0) return -1;

        int runningSum = 0;
        int minSteps = Integer.MAX_VALUE;

        for (int num: nums)
            runningSum += num;

        int lo = 0;
        int hi = 0;

        for(hi = 0; hi < nums.length; hi++)
        {
            // Sum of all elements - [0, lo) + (hi , nums.length]
            runningSum -= nums[hi];

            while (runningSum < x && lo <= hi)
                runningSum += nums[lo++];

            if (runningSum == x)
                minSteps = Math.min(minSteps, lo + (nums.length - 1 - hi));
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

}
