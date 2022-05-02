package leet_code_contests.weekly.wc291_20220430;

public class LC2262TotalAppealOfAString
{
    // Brute Force - Time Out
    private int getAppeal(char[] s, int start, int end)
    {
        if (start == end) return 1;
        int[] f = new int[26];
        int count = 0;
        for (int i = start; i <= end; i++)
        {
            f[s[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++)
        {
            if (f[i] > 0) count++;
        }
        return count;
    }
    public long appealSum(String s)
    {
        int n = s.length();
        int count = n;

        int l = 2;
        int i, j;
        int[] f = new int[26];
        char[] str = s.toCharArray();
        int start;

        while (l <= n)
        {
            for (i = 0; i <= n - l; i++)
            {
                start = i;
                while (start + 1 <= i + l - 1 &&  str[start] == str[start + 1]) start++;
                count += getAppeal(str, start, i + l - 1);
            }
            l++;
        }

        return count;

    }
}
