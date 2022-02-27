package leet_code_contests.weekly.wc282_20220226;

public class LC2186MinimumNumberOfStepsToMakeTwoStringsAnagramII {
    public int minSteps(String s, String t) {
        int[] ch = new int[26];
        int i;
        int steps = 0;

        for (i = 0; i < s.length(); i++)
        {
            ch[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < t.length(); i++)
        {
            ch[t.charAt(i) - 'a']--;
        }

        for (i = 0; i < 26; i++)
        {
            steps += Math.abs(ch[i]);
        }

        return steps;

    }
}
