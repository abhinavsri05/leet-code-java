package leet_code_contests.weekly.wc289_20220416;

public class LC2243CalculateDigitSumOfAString
{
    private int sumStr(String s)
    {
        int sum = 0;
        for (char c: s.toCharArray())
            sum += (c - '0');
        return sum;
    }
    public String digitSum(String s, int k)
    {
        int i = 0;
        while (s.length() > k)
        {
            StringBuilder temp = new StringBuilder();
            int n = s.length();
            for (i = 0; i < n; i += k)
            {
                if (i + k <= n)
                    temp.append(sumStr(s.substring(i, i + k)));
                else
                    temp.append(sumStr(s.substring(i, n)));
            }
            s = temp.toString();
        }
        return s;

    }
}
