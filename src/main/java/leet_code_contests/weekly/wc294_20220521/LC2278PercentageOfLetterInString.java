package leet_code_contests.weekly.wc294_20220521;

public class LC2278PercentageOfLetterInString
{
    public int percentageLetter(String s, char letter)
    {
        int count = 0;
        for (char c: s.toCharArray())
        {
            if (c == letter) count++;
        }

        return (int)(count * 100 / s.length());
    }
}
