package n05_dynamic_programming;

import java.util.HashSet;
import java.util.List;

public class LC0139WordBreak
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        int i, j;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (i = 1; i <= n; i++)
        {
            dp[i] = false;
            for (j = 1; j <= i; j++)
            {
                // Either 0-(i - 1) is a word or it can be broken down into multiple words
                dp[i] = dp[i] || (dp[j - 1] & dict.contains(s.substring(j - 1, i)));
            }
        }

        return dp[n];
    }
}
