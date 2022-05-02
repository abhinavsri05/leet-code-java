package leet_code_contests.weekly.wc291_20220430;

public class LC2259RemoveDigitFromNumberToMaximizeResult
{
    public String removeDigit(String number, char digit)
    {
        StringBuilder s = new StringBuilder(number);
        int n = s.length();
        int i;
        int remove = -1;

        for (i = n - 1; i >= 0; i--)
        {
            if (s.charAt(i) == digit && (remove == -1 || i < n - 1 && s.charAt(i + 1) > digit))
                remove = i;
        }

        s.deleteCharAt(remove);

        return s.toString();
    }
}
