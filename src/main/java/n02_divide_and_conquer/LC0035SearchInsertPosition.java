package n02_divide_and_conquer;

public class LC0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end)
        {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}
