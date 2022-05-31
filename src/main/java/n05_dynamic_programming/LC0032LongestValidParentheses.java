package n05_dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC0032LongestValidParentheses
{
    // My attempt - does not work for strings like ()(()
//    public int longestValidParentheses(String s)
//    {
//        Deque<Character> stack = new ArrayDeque<>();
//        int count = 0;
//        int maxCount = 0;
//        char temp;
//        for (char c: s.toCharArray())
//        {
//
//            if (c == '(')
//                stack.push(c);
//            else
//            {
//                if (!stack.isEmpty())
//                {
//                    temp = stack.pop();
//                    if (temp == '(')
//                    {
//                        count+=2;
//                        maxCount = Math.max(maxCount, count);
//                    }
//                    else
//                    {
//                        count = 0;
//                    }
//                }
//                else
//                {
//                    count = 0;
//                }
//            }
//        }
//
//        return maxCount;
//    }

    // Another attempt
    /*
        public int longestValidParentheses(String s)
    {
        int maxCount = 0;
        int[] dp = new int[s.length()];
        int i;

        for (i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == ')') // found a closing bracket
            {
                if (s.charAt(i - 1) == '(')
                {
                    if (i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                }
                else
                {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    {
                        if (i - dp[i - 1] >= 2)
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        else
                            dp[i] = dp[i - 1] + 2;
                    }
                }
                maxCount = Math.max(dp[i], maxCount);
            }
        }

        return maxCount;
    }
     */

    // From LC solution (a better soluion exists)
    public int longestValidParentheses(String s)
    {
        int maxCount = 0;
        int[] dp = new int[s.length()];
        int i;

        for (i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == ')') // found a closing bracket
            {
                if (s.charAt(i - 1) == '(')
                {
                    if (i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                }
                else
                {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    {
                        if (i - dp[i - 1] >= 2)
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        else
                            dp[i] = dp[i - 1] + 2;
                    }
                }
                maxCount = Math.max(dp[i], maxCount);
            }
        }

        return maxCount;
    }
}
