package n02_divide_and_conquer;

import java.util.PriorityQueue;

public class LC0215KthLargestElementInAnArray
{
    // Using Priority Queue
    public int findKthLargest1(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num: nums)
        {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }

    // QuickSelect
}
