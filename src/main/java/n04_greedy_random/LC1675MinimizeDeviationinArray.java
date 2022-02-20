package n04_greedy_random;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1675MinimizeDeviationinArray
{
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> evens = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        int minimum = Integer.MAX_VALUE;
        int dev = Integer.MAX_VALUE;
        int temp;

        for (int num: nums)
        {
            if ((num & 1) == 1)
                temp = num * 2;
            else
                temp = num;

            minimum = Math.min(minimum, temp);
            evens.add(temp);
        }

        while (!evens.isEmpty())
        {
            temp = evens.poll();
            dev = Math.min(dev, temp - minimum);
            if ((temp & 1) == 0)
            {
                minimum = Math.min(minimum, temp / 2);
                evens.add(temp / 2);
            }
            else
                break;
        }

        return dev;

    }
}
