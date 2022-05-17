package n09_string_manipulation;

public class LC0028ImplementstrStr
{
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 == 0 || l2 == 0 || l1 < l2) return -1;
        if (haystack.equals(needle)) return 0;

        int i, j;

        for (i = 0; i <= l1 - l2; i++)
        {
            if (haystack.charAt(i) == needle.charAt(0))
            {
                for (j = 1; j < l2; j++)
                {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                }
                if (j == l2)
                    return i;
            }
        }
        return -1;
    }
}
