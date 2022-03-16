package n09_string_manipulation;

import java.util.ArrayList;
import java.util.List;

public class LC1249MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder output = new StringBuilder(s.length());
        char ch;
        List<Integer> posnOpen = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == ')')
            {
                if (open == 0)
                    continue;
                else
                    open--;
            }
            if (ch == '(')
            {
                posnOpen.add(j);
                open++;
            }
            output.append(ch);
            j++;
        }

        int sz = posnOpen.size();

        for (int i = 0; i < open; i++)
        {
            j = posnOpen.get(sz - 1 - i);
            output.replace(j, j + 1, "");
        }

        return output.toString();
    }
}
