package n10_array_operations;

import java.util.PriorityQueue;

public class LC1354ConstructTargetArrayWithMultipleSums
{
    // My attempt - Times out
    /*
    Start backward
     */
    public boolean isPossible1(int[] target)
    {
        // Using Hints

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int nums: target)
        {
            sum += nums;
            pq.add(nums);
        }

        int max;
        int prevSum = 0;
        int addElement;
        while (prevSum != sum)
        {
            prevSum = sum;
            // System.out.println("\nPSum = " + prevSum);
            max = pq.poll();
            if (max == 1) return true;
            // System.out.println("Max = " + max);
            sum -= max;
            // System.out.println("Sum = " + sum);
            addElement = max - sum;
            if (addElement < 1) return false;
            pq.add(addElement);
            // System.out.println("Add Element = " + addElement);
            sum += (addElement);
            // System.out.println("New Sum = " + sum);
        }

        return false;
    }

    // Same logic as above but cleaner
    public boolean isPossible2(int[] target)
    {
        // Using Hints

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int nums: target)
        {
            sum += nums;
            pq.add(nums);
        }

        int max;
        int addElement;
        while (pq.element() > 1) // Top of queue
        {
            max = pq.poll();
            addElement = max - (sum - max);
            if (addElement < 1) return false;
            pq.add(addElement);
            sum += addElement - max;
        }

        return true;
    }

    public boolean isPossible(int[] target)
    {
        // Using Hints

        if (target.length == 1) return target[0] == 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int nums: target)
        {
            sum += nums;
            pq.add(nums);
        }

        int max;
        int addElement;
        while (pq.element() > 1) // Top of queue
        {
            max = pq.remove();
            if (sum - max == 1) return true;
            /*
            If maximum element is greater than the sum of all others combined then we will be subtracting the sum of all other several time.
            If max is not greater than sun of all others, then modulo will work same as addElement = max - (sum - max);
            Input: [8, 5], we add 8 - (13 - 8) = 8 - 5 = 3 which is same as 8 % 5. [13, 5] will also reduce to the same.
            */
            addElement = max % (sum - max);
            if (addElement == 0 || addElement == max) return false;
            pq.add(addElement);
            sum += addElement - max;

        }

        return true;
    }


}
