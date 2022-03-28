package n02_divide_and_conquer;

import java.util.PriorityQueue;

public class LC1337TheKWeakestRowsInAMatrix
{
    // Attempt 1
    public int[] kWeakestRows1(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[0] != j[0]) return i[0] - j[0];
            else return i[1] - j[1];
        });
        int[] ret = new int[k];
        int m = mat.length;
        int n = mat[0].length;
        int count;
        int i, j;

        for (i = 0; i < m; i++)
        {
            count = 0;
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] == 0) break;
                count++;
            }
            pq.add(new int[]{count, i});
        }

        for (i = 0; i < k; i++)
            ret[i] = pq.poll()[1];

        return ret;
    }

    // Attempt 2
    private int findFirstZero(int[] arr)
    {
        int start = 0, end = arr.length;
        int mid;

        while (start < end)
        {
            mid = start + (end - start) / 2;

            if (arr[mid] == 1)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[0] != j[0]) return i[0] - j[0];
            else return i[1] - j[1];
        });
        int[] ret = new int[k];
        int m = mat.length;
        int n = mat[0].length;
        int count;
        int i, j;

        for (i = 0; i < m; i++)
        {
            count = findFirstZero(mat[i]);
            pq.add(new int[]{count, i});
        }

        for (i = 0; i < k; i++)
            ret[i] = pq.poll()[1];

        return ret;
    }
}
