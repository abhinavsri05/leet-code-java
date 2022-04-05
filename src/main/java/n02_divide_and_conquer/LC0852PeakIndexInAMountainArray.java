package n02_divide_and_conquer;

public class LC0852PeakIndexInAMountainArray
{
    public int peakIndexInMountainArray(int[] arr)
    {
        int lo = 0;
        int hi = arr.length - 1;
        int mi;

        while (lo < hi)
        {
            mi = lo + (hi - lo) / 2;

            if (arr[mi] > arr[mi + 1])
                hi = mi;
            else
                lo = mi + 1;
        }

        return lo;
    }
}
