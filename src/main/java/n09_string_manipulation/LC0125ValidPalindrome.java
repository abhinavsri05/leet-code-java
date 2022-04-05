package n09_string_manipulation;

public class LC0125ValidPalindrome
{
    private boolean isChar(char c)
    {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private boolean isDigit(char c)
    {
        return ('0' <= c && c <= '9');
    }

    private char toLowerCase(char c)
    {
        if ('A' <= c && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public boolean isPalindrome(String s)
    {
        int first = 0;
        int second = s.length() - 1;
        char firstChar, secondChar;

        while (first <= second)
        {
            firstChar = s.charAt(first);
            secondChar = s.charAt(second);

            if (!isChar(firstChar) && !isDigit(firstChar))
            {
                first++;
                continue;
            }
            if (!isChar(secondChar) && !isDigit(secondChar))
            {
                second--;
                continue;
            }

            if (toLowerCase(firstChar) != toLowerCase(secondChar))
                return false;

            first++;
            second--;
        }

        return true;
    }
}
