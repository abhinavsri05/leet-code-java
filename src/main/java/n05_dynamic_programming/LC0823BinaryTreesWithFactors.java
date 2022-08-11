package n05_dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;

public class LC0823BinaryTreesWithFactors
{
    public int numFactoredBinaryTrees(int[] arr)
    {
        final int MOD = 1_000_000_007;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];

        Arrays.fill(dp, 1);

        int i, j, otherChild;
        long ret = 0L;

        HashMap<Integer, Integer> indices = new HashMap<>();
        for (i = 0; i < n; i++)
        {
            indices.put(arr[i], i);
        }

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (arr[i] % arr[j] == 0)
                {
                    // j becomes one of the child
                    otherChild = arr[i] / arr[j];
                    // Make sure the child exists
                    if (indices.containsKey(otherChild))
                    {
                        dp[i] = (dp[i] + dp[j] * dp[indices.get(otherChild)]) % MOD;
                    }
                }
            }
        }

        for (long d: dp)
        {
            ret = (ret + d) % MOD;
        }
        return (int)ret;
    }
}
