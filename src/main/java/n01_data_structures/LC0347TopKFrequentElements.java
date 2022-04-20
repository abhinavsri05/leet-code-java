package n01_data_structures;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC0347TopKFrequentElements
{
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, int[]> lastEntry = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[1] - j[1]);
        int i;
        int[] el;
        int[] output = new int[k];


        for (i = 0; i < nums.length; i++)
        {
            if (lastEntry.containsKey(nums[i]))
            {
                el = lastEntry.get(nums[i]);
                pq.remove(el);
            }
            else
                el = new int[]{nums[i], 0};

            el[1]++;
            pq.offer(el);
            if (pq.size() > k)
            {
                pq.poll();
            }

            lastEntry.put(nums[i], el);
        }

        i = 0;
        while (!pq.isEmpty())
            output[i++] = pq.poll()[0];

        return output;

    }
}
