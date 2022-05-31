package n09_string_manipulation;

public class LC0647PalindromicSubstrings
{
    public int countSubstrings(String s)
    {
        int n = s.length();
        int count = 0;
        int i;

        for (i = 0; i < n; i++)
        {
            // odd length;
            count += countPalindromesAroundCenter(s, n, i, i);

            // even length
            count += countPalindromesAroundCenter(s, n, i, i + 1);
        }
        return count;
    }

    private int countPalindromesAroundCenter(String s, int n, int start, int end)
    {
        /*
        Start moving away form the center and check if it still is a palindrome.
        */

        int count = 0;

        while (start >= 0 && end < n)
        {
            if (s.charAt(start) != s.charAt(end))
                break;
            count++;
            start--;
            end++;
        }

        return count;
    }
}
