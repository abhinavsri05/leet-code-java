package n02_divide_and_conquer;

public class LC0162FindPeakElement
{
    /*
    A peak element is an element that is strictly greater than its neighbors.

    Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞.

    You must write an algorithm that runs in O(log n) time.
     */

    public int findPeakElement(int[] nums)
    {
        return nums[search(nums, 0, nums.length - 1)];
    }

    private int search(int[] num, int startIndex, int endIndex)
    {
        if (startIndex == endIndex)
            return startIndex;
        if (startIndex > endIndex || num.length < 1)
            return -1;

        int mid = (startIndex + endIndex) / 2;

        if (num[mid] < num[mid + 1])
                return search(num, mid + 1, endIndex);

        return search(num, startIndex, mid);
    }

    public static void main(String[] args) {
        LC0162FindPeakElement sol = new LC0162FindPeakElement();
        int[] n = {-1, 0, 5, 4, 3, 2};
        System.out.println(sol.findPeakElement(n));

    }
}
