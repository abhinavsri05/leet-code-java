package leet_code_contests.weekly.wc287_20220402;

public class LC2224MinimumNumberOfOperationsToConvertTime
{
    public int convertTime(String current, String correct)
    {
        if (current.equals(correct)) return 0;
        int currentHour = Integer.parseInt(current.split(":")[0]);
        int currentMinute = Integer.parseInt(current.split(":")[1]);
        int correctHour = Integer.parseInt(correct.split(":")[0]);
        int correctMinute = Integer.parseInt(correct.split(":")[1]);

        int count = 0;

        int diffMinutes = 0;

        if (currentHour != correctHour)
        {
            if (correctHour -  1 > currentHour)
                diffMinutes =  diffMinutes + 60 * (correctHour -  currentHour - 1);
            if (correctHour < currentHour)
                diffMinutes += 60 * (23 - currentHour + correctHour);
            diffMinutes += 60 - currentMinute + correctMinute;
        }
        else
        {
            if (currentMinute < correctMinute)
                diffMinutes = correctMinute - currentMinute;
            else
                diffMinutes = 23 * 60 + currentMinute - correctMinute;
        }

        count += diffMinutes / 60;
        diffMinutes %= 60;
        count += diffMinutes / 15;
        diffMinutes %= 15;
        count += diffMinutes / 5;
        diffMinutes %= 5;
        count += diffMinutes;


        return count;
    }
}
