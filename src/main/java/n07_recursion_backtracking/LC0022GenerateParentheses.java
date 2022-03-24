package n07_recursion_backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0022GenerateParentheses
{
    private void backtrack(List<String> output, char[] temp, int n, int open, int close)
    {
        if (open == close && open == n)
        {
            output.add(new String(temp));
            return;
        }

        if (open == close)
        {
            temp[open + close] = '(';
            backtrack(output, temp, n, open + 1, close);
        }
        else if (open == n)
        {
            temp[open + close] = ')';
            backtrack(output, temp, n, open, close + 1);
        }
        else
        {
            temp[open + close] = '(';
            backtrack(output, temp, n, open + 1, close);
            temp[open + close] = ')';
            backtrack(output, temp, n, open, close + 1);
        }

    }
    public List<String> generateParenthesis(int n)
    {
        List<String> output = new LinkedList<>();
        char[] temp = new char[2 * n];

        int open = 0;
        int close = 0;

        backtrack(output, temp, n, open, close);

        return output;
    }
}
