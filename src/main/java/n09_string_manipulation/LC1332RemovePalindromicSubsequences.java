package n09_string_manipulation;

public class LC1332RemovePalindromicSubsequences
{
    public int removePalindromeSub(String s)
    {
        // There are only three scenarios possible since the string only contains 'a' and 'b'
        // If the string is empty then 0 steps.
        // If it already is a palindrome then 1 step
        // else 2 steps...in worst case first remove all a's then then all b's
        int start = 0;
        int end = s.length();
        if (end == 0) return 0;
        end --;
        while (start <= end)
        {
            if (s.charAt(start) != s.charAt(end)) return 2;
            start ++;
            end --;
        }
        return 1;
    }
}
