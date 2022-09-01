package n01_data_structures;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC0871MinimumNumberOfRefuelingStops
{
    // DP solution - not optimal
    public int minRefuelStops1(int target, int startFuel, int[][] stations)
    {
        int n = stations.length;
        // Maximum reacheable station with i refuelings
        long[] dp = new long[n + 1];
        dp[0] = startFuel;

        // The loops checks if it is possible to reach (i + 1)th station (1 indexed) using 0-(i + 1) refueiling

        for (int i = 0; i < n; i++)
        {
            for (int j = i; j >= 0; j--) // forward loop does not work. Why?
            {
                // Forward loop does not work since When we are trying to see if ith indexed station is reacheable by adding current station fuel. But if we use forward look then we may have already added current fuel as (j th) refuel. Then we cannot add that to (j + 1) th refuel.
                // Use below example to understand-
                /*
                457
                83
                [[25,27],[36,187],[140,186]]
                */
                if (dp[j] >= stations[i][0]) // If we cannot reach ith station with j refuelings then we cannot refuel at ith station
                {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + (long)stations[i][1]);
//                    System.out.println((j + 1) + " updated for i = " + i + " to " + dp[j + 1]);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));

        for (int i = 0; i <= n; i++)
        {
            if (dp[i] >= target) return i;
        }
        return -1;
    }

    // Using PriorityQueue
    public int minRefuelStops(int target, int startFuel, int[][] stations)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);

        int prevStation = 0;
        int fuel = startFuel;
        int refuels = 0;
        for (int[] station: stations)
        {
            fuel -= (station[0] - prevStation);
            if (fuel < 0)
            {
                while (!pq.isEmpty() && fuel < 0)
                {
                    fuel += pq.poll();
                    refuels++;
                }
                if (fuel < 0) return -1;
            }
            pq.offer(station[1]);
            prevStation = station[0];
        }

        while (!pq.isEmpty() && fuel < (target - prevStation))
        {
            fuel += pq.poll();
            refuels++;
        }

        return fuel < (target - prevStation) ? -1 : refuels;
    }
}

