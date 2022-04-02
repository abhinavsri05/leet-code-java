package n09_string_manipulation;

public class LC0680ValidPalindromeII
{
    private boolean checkPalindrome(char[] word, int start, int end)
    {
        while (start < end)
        {
            if (word[start] != word[end]) return false;
            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = word.length - 1;

        while (start < end)
        {
            if (word[start] == word[end])
            {
                start++;
                end--;
            }
            else
            {
                return checkPalindrome(word, start + 1, end) ||
                        checkPalindrome(word, start, end - 1);
            }
        }
        return true;
    }
}
