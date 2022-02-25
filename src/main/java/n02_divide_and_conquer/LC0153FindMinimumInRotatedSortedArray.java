package n02_divide_and_conquer;

public class LC0153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] <= nums[(mid - 1 + n) % n] && nums[mid] <= nums[(mid + 1 + n) % n])
                return nums[mid];

            if (nums[mid] >= nums[lo])
            {
                if (nums[mid] > nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            else
            {
                if (nums[mid] < nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return -1;

    }
    public int findMin2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        if (hi == 0) return nums[0];
        if (nums[hi] > nums[lo]) return nums[lo];

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            // The edge cases have been considered  - no rotation
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[mid] < nums[lo])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
