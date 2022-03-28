package n05_dynamic_programming;

public class LC0213HouseRobberII {
    private int houseRobberNonCircular(int[] nums, int start, int end)
    {
        int max = nums[start];
        int prev = 0;
        int temp;
        for (int i = start + 1; i < end; i++)
        {
            temp = max;
            max = Math.max(nums[i] + prev, max);
            prev = temp;
        }
        return max;
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(houseRobberNonCircular(nums, 0, n - 1), houseRobberNonCircular(nums, 1, n));

    }
}
