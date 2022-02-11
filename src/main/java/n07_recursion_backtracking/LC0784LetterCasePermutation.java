package n07_recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0784LetterCasePermutation
{
    /*
    Backtracking approach.
A loop is not required since we start with first character and as we move to others we just chanck for them bein alphabet and change case and continue. The starting point need not iterate over all characters otherwise that will result in duplicates. There will be at most two root node uppercase and lower case first letter.
     */
    private void backtrack(int length, StringBuilder str, ArrayList<String> output, int posn)
    {
        char ch;
        if (posn == length)
        {
            output.add(new String(str));
            return;
        }

        ch = str.charAt(posn);
        backtrack(length, str, output, posn + 1);
        if ('a' <= ch && ch <= 'z')
        {
            str.setCharAt(posn, (char)(ch - ('a' - 'A')));
            backtrack(length, str, output, posn + 1);
            str.setCharAt(posn, ch);
        }
        if ('A' <= ch && ch <= 'Z')
        {
            str.setCharAt(posn, (char)(ch + ('a' - 'A')));
            backtrack(length, str, output, posn + 1);
            str.setCharAt(posn, ch);
        }

    }


    public List<String> letterCasePermutation(String s)
    {
        StringBuilder str = new StringBuilder(s);

        ArrayList<String> output = new ArrayList<String>();

        backtrack(s.length(), str, output, 0);

        return output;

    }
}
