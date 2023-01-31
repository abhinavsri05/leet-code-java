package additional;

import java.util.Arrays;

/*
Minimum distance from src to destination taking at least k hops (edges)
 */
public class MinDistance
{
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        int[][] dp = new int[2*n + 1][n];

        int i, j;
        // int n = flights.length;

        int[][] graph = new int[n][n];

        for (int[] f: flights)
        {
            graph[f[0]][f[1]] = f[2];
        }

        for (int[] d: dp)
        {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dp[0][src] = 0;

        for (i = 1; i <= 2 * n; i++)
        {
            for (j = 0; j < n; j++)
            {
//                dp[i][j] = Integer.MAX_VALUE;
                for (int v = 0; v < n; v++)
                {
                    if (v == j || dp[i - 1][v] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][v] + graph[v][j]);
                }
            }
        }

        // for (i = 0; i < n + 1; i++)
//        System.out.println(Arrays.deepToString(dp));

        int minV = Integer.MAX_VALUE;
        int steps = 0;
        for (i = k; i <= 2 * n; i++)
        {
            if (dp[i][dst] < minV) {
                minV = dp[i][dst];
                steps = i;
            }
        }
//        System.out.println(steps);
        return minV;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1}, {0, 2, 1000}, {0, 3, 1000}, {1, 0, 1000}, {1, 2, 1000}, {1, 3, 1}, {2, 0, 1}, {2, 1, 1000}, {2,3,1000},{3,0,1000},{3,1,1000},{3,2,1}};

        int [][] r = new int[4][4];

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                r[i][j] = findCheapestPrice(4, arr, i, j, 4);
            }
        }

        System.out.println(Arrays.deepToString(r));


    }
}
