package leet_code_contests.weekly.wc282_20220226;

// https://leetcode.com/problems/minimum-time-to-complete-trips/discuss/1802416/C%2B%2B-or-Answer-on-Binary-Search-or-List-of-Related-Problems

public class LC2187MinimumTimeToCompleteTrips {
    // Here upper bound is Long.MAX_VALUE
    public long minimumTime(int[] time, int totalTrips) {
        long lb = 0;
        // long ub = (long)Math.pow(10, 15);
        long ub = Long.MAX_VALUE;
        // long ub = 9223372036854775800l;

        long mid;
        long trips;

        while (lb <= ub)
        {
            mid = lb + (ub - lb) / 2;
            trips = 0;
            for (int t: time)
            {
                // Due to high upperbound, trips may overflow, giving incorrect answer
                trips += (mid / t);
                if(trips < 0)
                {
                    ub = mid-1;
                    break;
                }
            }
            if(trips < 0)
                continue;

            if (trips < (long)totalTrips)
                lb = mid + 1;
            else
                ub = mid - 1;
        }

        return lb;

    }

    // Upper bound will be the minimum time any bus takes to complete 1 trip (min(time) * totalTrips.
    // The max possible value in time is 10^7 amd max of totalTrips is 10^7 so upper bound is at max 10^14
    // If there is only one bus that takes 10^7 unit time to complete one trip, so it will take 10^7 time units
    // to complete 10^7 trips.

    public long minimumTime2(int[] time, int totalTrips) {
        long lb = 1; // does not has to be 0
        long ub = (long)Math.pow(10, 14);

        long mid;
        long trips;

        while (lb <= ub)
        {
            mid = lb + (ub - lb) / 2;
            trips = 0;
            for (int t: time)
            {
                trips += (mid / t);
            }

            if (trips < (long)totalTrips)
                lb = mid + 1;
            else
                ub = mid - 1;
        }

        return lb;

    }
}
