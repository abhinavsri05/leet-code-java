package n10_array_operations;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1874MinimizeProductSumOfTwoArrays
{
    public int minProductSum(int[] nums1, int[] nums2)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);
        Arrays.sort(nums1);

        int prodSum = 0;
        int i;

        for (i = 0; i < nums2.length; i++)
            pq.offer(nums2[i]);

        for (i = 0; i < nums1.length; i++)
        {
            prodSum += nums1[i] * pq.poll();
        }

        return prodSum;

    }
}
