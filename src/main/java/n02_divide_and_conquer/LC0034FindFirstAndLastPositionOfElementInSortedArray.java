package n02_divide_and_conquer;

public class LC0034FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target)
    {
        int lo = 0;
        int hi = nums.length - 1;

        int mid;
        int start = -1;
        int end = -1;

        // Find start

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
            {
                start = mid;
                break;

            }

            if (nums[mid] >= target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        if (start == -1)
        {
            return new int[]{-1, -1};
        }

        // Find end

        while (hi < nums.length - 1 && nums[hi] <= target)
        {
            hi = Math.min(nums.length - 1, Math.max(hi, 1) * 2);
        }
        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target))
            {
                end = mid;
                break;
            }
            if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;

        }

        return new int[]{start, end};

    }
}
