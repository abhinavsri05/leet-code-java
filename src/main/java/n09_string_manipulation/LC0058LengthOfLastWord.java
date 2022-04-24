package n09_string_manipulation;

public class LC0058LengthOfLastWord
{
    public int lengthOfLastWord(String s)
    {
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == ' ' && end >= 0)
                return end - i; // + 1 not required since i is not the first character
            if (s.charAt(i) != ' ' && end == -1) end = i;
        }
        return end + 1; // Only one word
    }
}
