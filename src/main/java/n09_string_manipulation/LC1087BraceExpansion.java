package n09_string_manipulation;

import java.util.Arrays;
import java.util.LinkedList;

public class LC1087BraceExpansion
{
    private void addStrings(LinkedList<String> l, LinkedList<String> q, char c)
    {
        for (String s: l)
        {
            // System.out.println("Adding " + c + " to " + s);
            q.add(s + c);
        }
    }
    public String[] expand(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        LinkedList<String> q = new LinkedList<>();

        int length = 0;
        int idx = 0;
        q.add("");

        while (idx < n)
        {
            LinkedList<String> strs = new LinkedList<>();
            while (!q.isEmpty() && q.peek().length() == length)
            {
                // System.out.println("Here: " + q.peek());
                strs.add(q.remove());
            }
            if (ch[idx] == '{')
            {
                idx++;
                // Below check handles {} - but it is not a valid input.
                // if (ch[idx] == '}')
                // {
                //     for (String str: strs)
                //         q.add(str);
                // }
                while (ch[idx] != '}')
                {
                    if (ch[idx] != ',')
                        addStrings(strs, q, ch[idx]);
                    idx++;
                }
            }
            else
            {
                addStrings(strs, q, ch[idx]);
            }
            idx++;
            length++;
        }

        String[] output = q.toArray(new String[q.size()]);
        Arrays.sort(output);
        return output;
    }
}
