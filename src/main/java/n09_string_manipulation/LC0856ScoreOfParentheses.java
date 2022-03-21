package n09_string_manipulation;

import java.util.Stack;

public class LC0856ScoreOfParentheses
{
    // LC Solution using Stack
    public int scoreOfParentheses(String s)
    {
        Stack<Integer> stack = new Stack<>();
        char ch;
        int u, v;

        stack.push(0);

        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == '(')
                stack.push(0);
            else
            {
                u = stack.pop();
                v = stack.pop();
                stack.push(v + Math.max(2 * u, 1));
            }

        }

        return stack.pop();
    }
}
