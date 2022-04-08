package n01_data_structures;

import java.util.PriorityQueue;

public class LC1046LastStoneWeight
{
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);
        int x, y;
        // Add elements to PQ

        for (int stone: stones)
            pq.offer(stone);

        while (pq.size() > 1)
        {
            y = pq.poll();
            x = pq.poll();
            if (x != y)
                pq.offer(y - x);
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
