package n05_dynamic_programming;

public class P0070ClimbingStairs {
//    public int climbStairs(int n)
//    {
//        int[] ways = new int[n + 1];
//
//        ways[0] = 1;
//        ways[1] = 2;
//
//        for (int i = 3; i <= n; i++)
//        {
//            ways[i - 1] = ways[i - 2] + ways[i - 3];
//        }
//
//        return ways[n - 1];
//
//    }

    public int climbStairs(int n)
    {
        if (n == 1) return 1;
        int prev = 1;
        int prev_prev = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++)
        {
            curr = prev + prev_prev;
            prev_prev = prev;
            prev = curr;
        }

        return curr;

    }
}
