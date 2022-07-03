package leet_code_contests.weekly.wc298_20220618;

public class LC2309GreatestEnglishLetterInUpperAndLowerCase
{
    public String greatestLetter(String s)
    {
        // This solution fails for Aa
        int[] found = new int[26];

        for (char c: s.toCharArray())
        {
            if ('a' <= c && c <= 'z' && (found[c - 'a'] == 0 || found[c - 'a'] == 2))
                found[c - 'a'] ++;
            if ('A' <= c && c <= 'Z' && found[c - 'A'] == 1) // This condition is incomplete. Should be if ('A' <= c && c <= 'Z' && (found[c - 'A'] == 0 || found[c - 'A'] == 1))
                found[c - 'A'] += 2;
        }

        for (int i = 25; i >= 0; i--)
        {
            if (found[i] == 3)
                return "" + (char)(i + 'A');
        }

        return "";
    }

    public String greatestLetter2(String s)
    {
        int[] found = new int[26];

        for (char c: s.toCharArray())
        {
            if ('a' <= c && c <= 'z')
                found[c - 'a'] |= 1;
            if ('A' <= c && c <= 'Z')
                found[c - 'A'] |= 2;
        }

        for (int i = 25; i >= 0; i--)
        {
            if (found[i] == 3)
                return "" + (char)(i + 'A');
        }

        return "";
    }
}
