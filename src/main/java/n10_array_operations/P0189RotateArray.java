package n10_array_operations;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

public class P0189RotateArray
{

    public void rotate(int[] nums, int k) {
        /* Solution 1
        int n = nums.length;
        k = k % n;

        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);


    }

    private void reverseArray(int[] nums, int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    */

        /* Solution 2

        Will not work if k = nums.length/2

        int i = 0;
        int curr_idx = 0;
        int curr_val = nums[0];
        int next_val;

        while (i < nums.length)
        {
            curr_idx = (curr_idx + k) % nums.length;
            next_val = nums[curr_idx];
            nums[curr_idx] = curr_val;
            i++;
            curr_val = next_val;
        }

        */

        /* Solution 3 */



    }
}
