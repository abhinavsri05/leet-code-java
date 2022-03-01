package n02_divide_and_conquer;

public class LC0209MinimumSizeSubarraySum {
    public int minSubArrayLen1(int target, int[] nums) {
        int length = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int i, j;

        // Each element visited at most twice
        for (i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            length++;
            if (sum >= target)
            {
                j = i - length + 1;
                while (j < i)
                {
                    if (sum - nums[j] >= target)
                    {
                        sum -= nums[j];
                        length--;
                    }
                    else
                        break;
                    j++;
                }
                minLength = Math.min(minLength, length);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }


}
