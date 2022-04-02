package n10_array_operations;

import java.util.Random;

public class LC0384ShuffleAnArray
{
    int[] nums;
    int[] orig;
    int n;
    Random rand;

    public LC0384ShuffleAnArray(int[] nums)
    {
        this.nums = nums;
        this.orig = nums.clone();
        this.n = nums.length;
        this.rand = new Random();

    }

    public int[] reset()
    {
        return orig.clone();
    }

    public int[] shuffle()
    {
        int idx;
        int temp;
        for (int i = 1; i < n; i++)
        {
            idx = rand.nextInt(this.n);
            temp = this.nums[idx];
            this.nums[idx] = this.nums[i];
            this.nums[i] = temp;
        }
        return this.nums;

    }
}
