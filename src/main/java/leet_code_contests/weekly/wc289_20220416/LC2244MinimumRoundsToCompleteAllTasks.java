package leet_code_contests.weekly.wc289_20220416;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC2244MinimumRoundsToCompleteAllTasks
{
    // My solution (Time was not good)
    public int minimumRounds1(int[] tasks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int currFreq;
        for (int d: tasks)
        {
            currFreq = freq.getOrDefault(d, 0) + 1;
            freq.put(d, currFreq);
            // System.out.println("Put: (" + d + ", " + currFreq + ")");
        }

        int count = 0;

        while (!freq.isEmpty())
        {
            Set<Integer> set = new HashSet<>(freq.keySet());
            for (int k: set)
            {
                currFreq = freq.get(k);
                // System.out.println("Key: " + k + ", Freq: " + currFreq);
                if (currFreq == 0)
                {
                    freq.remove(k);
                    continue;
                }
                if (currFreq >= 3 && currFreq % 3 != 1) // for [5, 5, 5, 5]
                {
                    count++;
                    freq.put(k, currFreq - 3);
                }
                else
                {
                    if (currFreq >= 2)
                    {
                        count++;
                        freq.put(k, currFreq - 2);
                        // freq.remove(k);
                    }
                    else
                    {
                        return -1;
                    }
                }
            }
        }
        return count;

    }

    // Rank# 1 solution
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int i, j;
        int count = 0;

        for (i = 0; i < tasks.length;)
        {
            j = i;
            while (i < tasks.length && tasks[i] == tasks[j]) i++;
            if (i - j == 1) return -1;

            // Note: there cannot be more than 2 rounds that complete 2 tasks of same difficulty levels. All other rounds will finish 3 tasks of same difficulty. This is true since 3 rounds of 2 tasks is 2 rounds of 3 tasks.
            count += (i - j + 2) / 3;
        }
        return count;
    }
}
