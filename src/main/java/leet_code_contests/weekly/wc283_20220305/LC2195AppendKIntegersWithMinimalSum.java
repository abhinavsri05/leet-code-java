package leet_code_contests.weekly.wc283_20220305;

import java.util.Arrays;

public class LC2195AppendKIntegersWithMinimalSum {
    private long getSum(int n)
    {
        return n * (n + 1l) / 2l;
    }

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] > k)
        {
            return getSum(k);
        }

        int count = nums[0] - 1;
        long sum = getSum(count);

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] <= nums[i - 1] + 1) continue;
            if (count + nums[i] - nums[i - 1] - 1 >= k)
            {
                sum += getSum(nums[i - 1] + k - count) - getSum(nums[i - 1]);
                count = k;
                break;
            }
            count += nums[i] - nums[i - 1] - 1;
            sum += getSum(nums[i] - 1) - getSum(nums[i - 1]);
        }

        if (count < k)
        {
            sum += getSum(nums[nums.length - 1] + k - count) - getSum(nums[nums.length - 1]);
        }

        return sum;

    }

    public long minimalKSum2(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = k * (k + 1L) / 2L;
        int next = k + 1;

        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] < next)
            {
                sum = sum - nums[i] + next;
                next++;
            }
        }

        return sum;

    }

}
