package n04_greedy_random;

import java.util.Arrays;

public class LC1029TwoCityScheduling {
    // Leet Code Soln
    public int twoCitySchedCost(int[][] costs)
    {
        Arrays.sort(costs, (i, j) -> (i[0] - i[1]) - (j[0] - j[1]));

        int cost = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++)
            cost += costs[i][0] + costs[n + i][1];

        return cost;
    }
}
