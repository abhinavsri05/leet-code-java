package n10_array_operations;

public class LC1423MaximumPointsYouCanObtainFromCards
{
    public int maxScore1(int[] cardPoints, int k)
    {
        /* Greedy solution - does not work for following-
        [11,49,100,20,86,29,72]
        4
        Expected: 232
        */
        int count = 0;
        int lo = 0;
        int hi = cardPoints.length - 1;
        int sum = 0;

        while (count < k)
        {
            if (cardPoints[lo] > cardPoints[hi])
                sum+=cardPoints[lo++];
            else
                sum+=cardPoints[hi--];
            count++;
        }

        return sum;
    }

    public int maxScore2(int[] cardPoints, int k)
    {
        int n = cardPoints.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        int i;
        // We do not need to precalculate the prefix sum
        for (i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + cardPoints[i];

        int window = n - k;
        int minSum = Integer.MAX_VALUE;

        for (i = 0; i <= k; i++)
            minSum = Math.min(minSum, prefixSum[i + n - k] - prefixSum[i]); // Window size is n - k

        return prefixSum[n] - minSum;
    }

    public int maxScore3(int[] cardPoints, int k)
    {
        int n = cardPoints.length;
        int i;
        int runningSum = 0;

        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;
        // Window size = n - k
        for (i = 0; i < n; i++)
        {
            totalSum += cardPoints[i];
            runningSum += cardPoints[i];
            if (i >= n - k - 1)
            {
                if (i > n - k - 1) // To count first window as well
                    runningSum -= cardPoints[i - n + k];
                minSum = Math.min(minSum, runningSum);
            }
        }
        return totalSum - minSum;
    }
}
