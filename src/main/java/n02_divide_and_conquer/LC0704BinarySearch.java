package n02_divide_and_conquer;

public class LC0704BinarySearch
{
    public int search(int[] nums, int target)
    {
        int start, end, mid;

        start = 0;
        end = nums.length - 1;

        if (nums[start] > target || nums[end] < target)
            return -1;

        while(true)
        {
            if (start > end)
                return -1;

            mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
    }

}
