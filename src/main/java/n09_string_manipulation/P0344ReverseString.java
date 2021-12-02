package n09_string_manipulation;

public class P0344ReverseString {
    public void reverseString(char[] s)
    {
        char temp;
        int start = 0;
        int end = s.length - 1;

        while (start <= end)
        {
            temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
}
