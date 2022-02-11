package n10_array_operations;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

import java.util.Arrays;

public class LC0189RotateArray
{
    public static void rotate2(int[] nums, int k)
    {
        int i = 0;
        int curr_idx = 0;
        int curr_val = nums[0];
        int next_val;
        System.out.println("Initial: " + Arrays.toString(nums));
        while (i < nums.length)
        {
            curr_idx = (curr_idx + k) % nums.length;
            next_val = nums[curr_idx];
            nums[curr_idx] = curr_val;
            i++;
            curr_val = next_val;
            System.out.println("Updated (" + i + ") : " + Arrays.toString(nums));
        }
    }


    public static void rotate(int[] nums, int k) {
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
        We need to handle the case where we reach the starting position due to cycles

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

        /* Solution 3 -- Copied from LeetCode solutions */

        k = k % nums.length;
        int count = 0;
        System.out.println("Initial: " + Arrays.toString(nums));
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            System.out.println("Start = " + start);
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
                System.out.println("Updated (" + count + ") : " + Arrays.toString(nums));
            } while (start != current);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
