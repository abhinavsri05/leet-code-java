package n05_dynamic_programming;

public class LC0091DecodeWays
{
    // Attempt 1
    boolean isValid1(String s)
    {
        if (s.equals("")) return false;
        if (s.charAt(0) == '0') return false;
        if (s.length() > 2) return false;
        return Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 26;
    }

    public int numDecodings1(String s) {
        int i, j;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;


        // Instead of checking all length, should check only 2 length at a time
        for (i = 1; i <= n; i++)
        {
            dp[i] = 0;
            for (j = 1; j <= i; j++)
            {
                if (dp[j - 1] > 0 && isValid1(s.substring(j - 1, i)))
                {
                    dp[i] += dp[j - 1];
                }
            }
        }

        return dp[n];

    }

    // Attempt 2 O(n) solution
    boolean isValid(String s)
    {
        if (s.charAt(0) == '0') return false;
        return Integer.parseInt(s) >= 1 && Integer.parseInt(s) <= 26;
    }

    public int numDecodings(String s) {
        int i, j;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        if (s.charAt(0) != '0')
            dp[1] = 1;
        else
            return 0;

        for (i = 2; i <= n; i++)
        {
            dp[i] = 0;
            for (j = i - 2; j < i; j++) // Runs exactly 2 times always
            {
                if (dp[j] > 0 && isValid(s.substring(j, i)))
                {
                    dp[i] += dp[j];
                }
            }
        }

        return dp[n];

    }
}
