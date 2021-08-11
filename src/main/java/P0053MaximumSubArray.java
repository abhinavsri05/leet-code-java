/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        A subarray is a contiguous part of an array.

*/
public class P0053MaximumSubArray
{
    public int maxSubArray(int[] nums)
    {
        int curr = nums[0];
        int maxVal = nums[0];
        int num;

        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            curr = Math.max(num, curr + num);
            maxVal = Math.max(maxVal, curr);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        P0053MaximumSubArray sol = new P0053MaximumSubArray();
        System.out.println(sol.maxSubArray(nums));
    }
}
