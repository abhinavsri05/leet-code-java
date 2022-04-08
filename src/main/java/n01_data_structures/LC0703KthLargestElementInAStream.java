package n01_data_structures;

import java.util.PriorityQueue;

public class LC0703KthLargestElementInAStream
{
    private PriorityQueue<Integer> pq;
    private int k;

    public LC0703KthLargestElementInAStream(int k, int[] nums)
    {
        this.pq = new PriorityQueue();
        this.k = k;
        int i;

        for (i = 0; i < nums.length; i++)
        {
            if (pq.size() < k)
                pq.offer(nums[i]);
            else
            {
                if (pq.peek() < nums[i])
                {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

    }

    public int add(int val)
    {
        if (pq.size() < k)
            pq.offer(val);
        else
        {
            if (pq.peek() < val)
            {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}
