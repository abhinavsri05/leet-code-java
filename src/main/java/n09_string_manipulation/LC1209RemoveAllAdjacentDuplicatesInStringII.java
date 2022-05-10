package n09_string_manipulation;

public class LC1209RemoveAllAdjacentDuplicatesInStringII
{
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[s.length()]; //memoize counts
        int i;

        for (i = 0; i < sb.length(); i++) // cannot use s.length()
        {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1))
            {
                count[i] = 1;
            }
            else
            {
                count[i] = count[i - 1] + 1;
                if (count[i] == k)
                {
                    sb.delete(i - k + 1, i + 1); // duplicates of length exactly k
                    i = i - k;
                }
            }
        }
        return sb.toString();

    }
}
