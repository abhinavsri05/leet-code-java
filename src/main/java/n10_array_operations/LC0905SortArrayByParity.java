package n10_array_operations;

public class LC0905SortArrayByParity
{
    private void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int[] sortArrayByParity(int[] nums)
    {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi)
        {
            if (nums[lo] % 2 == 1 && nums[hi] % 2 == 0)
                swap(nums, lo++, hi--);
            if (nums[lo] % 2 == 0) lo++;
            if (nums[hi] % 2 == 1) hi--;
        }
        return nums;
    }
}
