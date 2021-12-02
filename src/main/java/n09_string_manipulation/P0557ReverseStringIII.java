package n09_string_manipulation;

public class P0557ReverseStringIII {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ret = new StringBuilder();
        int offset;
        for (int i = 0; i < n; i++)
        {
            if (i == n - 1 || s.charAt(i) == ' ')
            {
                if (i == n - 1)
                    offset = 0;
                else
                    offset = 1;
                while (i - offset >= 0 && s.charAt(i - offset) != ' ')
                {
                    ret.append(s.charAt(i - offset));
                    offset++;
                }

                if (i < n - 1) ret.append(s.charAt(i));
            }
        }
        return ret.toString();

    }
}
