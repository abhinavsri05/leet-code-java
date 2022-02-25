package n01_data_structures;

public class LC1064FixedPoint {
    public int fixedPoint1(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if (((mid > 0 && arr[mid - 1] != mid - 1) || (mid == 0)) && mid == arr[mid]) return mid;

            if (arr[mid] < mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;

    }

    public int fixedPoint(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        int ans = -1;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == mid)
            {
                hi = mid - 1;
                ans = mid;
            }
            else
            if (arr[mid] < mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return ans;

    }
}
