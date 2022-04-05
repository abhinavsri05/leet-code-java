package n10_array_operations;

public class LC0027RemoveElement
{
    private void swap(int[] nums, int i, int j)
    {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public int removeElement(int[] nums, int val)
    {
        int n = nums.length - 1;
        int i = 0;

        for (; i <= n; i++)
        {
            if (nums[i] == val)
            {
                while (n >= 0 && nums[n] == val) n--;
                if (n < i) break;
                swap(nums, i, n);
                n--;
            }
        }

        return n < 0 ? 0 : n + 1;
    }
}
