package n10_array_operations;

import java.util.PriorityQueue;

public class LC0378KthSmallestElementInASortedMatrix
{
    public int kthSmallest(int[][] matrix, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[0] - j[0]);

        int n = matrix.length;

        int[] head;
        int res = 0;

        // Add first element of each column to the min heap DS
        for (int i = 0; i < n; i++)
        {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        // Remove k heads of heap and at each step add the next element of the column the element was removed from (if there exists)

        while (k > 0)
        {
            k--;
            head = pq.remove();
            res = head[0];
            if (head[2] < n - 1)
                pq.add(new int[]{matrix[head[1]][head[2] + 1], head[1], head[2] + 1});
        }

        return res;
    }
}
