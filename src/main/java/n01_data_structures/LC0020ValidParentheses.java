package n01_data_structures;

import java.util.LinkedList;

public class LC0020ValidParentheses
{
    // First Attempt
    public boolean isValid(String s) {
        LinkedList<Integer> q = new LinkedList<>();

        char[][] brackets = {
                {'(', '{', '['},
                {')', '}', ']'}
        };
        int i, j, idx;
        int l = s.length();
        char ch;

        for (i = 0; i < l; i++)
        {
            ch = s.charAt(i);
            idx = -1;

            for (j = 0; j < 3; j++)
            {
                if (brackets[0][j] == ch)
                {
                    idx = j;
                    break;
                }
            }

            if (idx >= 0)
            {
                q.push(idx);
                continue;
            }
            else
            {
                if (q.size() <= 0) return false;
                j = q.pop();
                if (ch == brackets[1][j])
                    continue;
                else
                    return false;
            }

        }

        if (q.size() == 0)
            return true;
        else
            return false;

    }

    //Second Attempt
    public boolean isValid2(String s) {
        LinkedList<Character> q = new LinkedList<>();
        int l = s.length();
        char ch, read;

        for (int i = 0; i < l; i++)
        {
            ch = s.charAt(i);

            switch (ch)
            {
                case '(':
                    q.push(ch);
                    break;

                case ')':
                    if (q.size() == 0) return false;
                    read = q.pop();
                    if (read != '(') return false;
                    break;

                case '{':
                    q.push(ch);
                    break;

                case '}':
                    if (q.size() == 0) return false;
                    read = q.pop();
                    if (read != '{') return false;
                    break;

                case '[':
                    q.push(ch);
                    break;

                case ']':
                    if (q.size() == 0) return false;
                    read = q.pop();
                    if (read != '[') return false;
                    break;
            }

        }

        if (q.size() == 0)
            return true;
        else
            return false;
    }
}
