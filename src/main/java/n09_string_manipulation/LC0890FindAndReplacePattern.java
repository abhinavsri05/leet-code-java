package n09_string_manipulation;

import java.util.LinkedList;
import java.util.List;

public class LC0890FindAndReplacePattern
{
    private boolean patternMatches(String word, String pattern)
    {
        int[] forward = new int[26];
        int[] backward = new int[26];

        int w, p;

        for (int i = 0; i < word.length(); i++)
        {
            w = word.charAt(i) - 'a';
            p = pattern.charAt(i) - 'a';

            if (forward[w] == 0)
            {
                forward[w] = p + 1;
                if(backward[p] == 0)
                {
                    backward[p] = w + 1;
                }
                else
                {
                    if (backward[p] != w + 1)
                        return false;
                }

            }
            else
            {
                if (forward[w] != p + 1) return false;
            }
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern)
    {
        int lenPat = pattern.length();
        List<String> output = new LinkedList<>();

        for (String s: words)
        {
            if (s.length() != lenPat) continue;
            if (patternMatches(s, pattern))
            {
                output.add(s);
            }
        }
        return output;
    }
}
