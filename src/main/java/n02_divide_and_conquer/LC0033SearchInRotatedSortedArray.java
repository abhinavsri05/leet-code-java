package n02_divide_and_conquer;

public class LC0033SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int mid;
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[lo])
            {
                if (nums[lo] <= target && nums[mid] > target)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else
            {
                if (nums[hi] >= target && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return -1;

    }
}
