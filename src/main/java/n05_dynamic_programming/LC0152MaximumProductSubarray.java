package n05_dynamic_programming;

public class LC0152MaximumProductSubarray
{
    public int maxProduct(int[] nums)
    {
        int maxProd = nums[0];
        int minProd = nums[0];
        int maxValue = nums[0];
        int maxTemp;

        for (int l = 1; l < nums.length; l++)
        {
            maxTemp = Math.max(nums[l], Math.max(nums[l] * minProd, nums[l] * maxProd));
            minProd = Math.min(nums[l], Math.min(nums[l] * minProd, nums[l] * maxProd));
            maxProd = maxTemp;
            maxValue = Math.max(maxProd, maxValue);

        }
        return maxValue;
    }
    // Not sure why this one works
    public int maxProduct2(int[] nums)
    {
        int maxProd = Integer.MIN_VALUE;
        int tempMax = 1;
        int i;

        for (i = 0; i < nums.length; i++)
        {
            tempMax = tempMax * nums[i];
            maxProd = Math.max(tempMax, maxProd);
            if (tempMax == 0) tempMax = 1;
        }
        tempMax = 1;
        for (i = nums.length - 1; i >= 0; i--)
        {
            tempMax = tempMax * nums[i];
            maxProd = Math.max(tempMax, maxProd);
            if (tempMax == 0) tempMax = 1;
        }

        return maxProd;
    }
}
