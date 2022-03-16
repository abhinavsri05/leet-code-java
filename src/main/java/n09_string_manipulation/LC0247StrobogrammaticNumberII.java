package n09_string_manipulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0247StrobogrammaticNumberII
{
    // Recursive Approach
    private static final char[][] pairs = {
            {'6', '9'}, {'9', '6'},
            {'0', '0'},
            {'1', '1'},
            {'8', '8'}};

    public List<String> getStrobogrammatic(int n, boolean finalIter)
    {
        if (n == 0)
            return new ArrayList<>(List.of(""));

        if (n == 1)
            return new ArrayList<>(List.of("0", "1", "8"));

        List<String> prev = getStrobogrammatic(n - 2, false);
        List<String> curr = new ArrayList<>();

        for (String s: prev)
        {
            for (char[] pair : pairs)
            {
                if (pair[0] != '0' || !finalIter)
                    curr.add(pair[0] + s + pair[1]);
            }
        }

        return curr;

    }

    public List<String> findStrobogrammatic(int n)
    {
        return getStrobogrammatic(n, true);

    }

    // Iterative Solution

    public List<String> findStrobogrammatic2(int n)
    {
        Queue<String> q = new LinkedList<>();
        int l;

        List<String> result = new ArrayList<>();

        String curr;

        if (n % 2 == 0)
            q.add("");
        else
        {
            q.add("0");
            q.add("1");
            q.add("8");
        }

        if (n == 1)
            return new ArrayList<String>(List.of("0", "1", "8"));

        while (n > 1 && !q.isEmpty())
        {
            curr = q.remove();

            l = curr.length() + 2;;

            for (char[] pair: pairs)
            {
                if (pair[0] != '0' || l != n)
                {
                    if (l != n)
                        q.add(pair[0] + curr + pair[1]);
                    else
                        result.add(pair[0] + curr + pair[1]);
                }
            }
        }

        return result;

    }
}
