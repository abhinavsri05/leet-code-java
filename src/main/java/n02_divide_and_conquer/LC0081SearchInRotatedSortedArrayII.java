package n02_divide_and_conquer;

public class LC0081SearchInRotatedSortedArrayII
{
    // Copied from a solution posted on Solutions discussion thread. It modifies the one in LC0033
    public boolean search(int[] nums, int target) {
        int mid;
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] > nums[lo])
            {
                if (nums[lo] <= target && nums[mid] > target)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else
            {
                if (nums[mid] < nums[lo])
                {
                    if (nums[hi] >= target && target >= nums[mid])
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }
                else
                    lo++;
            }
        }

        return false;

    }
}
