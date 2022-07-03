package n10_array_operations;

public class LC0665NonDecreasingArray
{
    public boolean checkPossibility(int[] nums)
    {
        if (nums.length == 1) return true;
        int outOfOrder = 0;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                if (outOfOrder == 1) return false;
                outOfOrder = 1;
                if (i < 2 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}
