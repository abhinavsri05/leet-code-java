package n09_string_manipulation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1647MinimumDeletionsToMakeCharacterFrequenciesUnique
{
    // First attempt
    public int minDeletions1(String s)
    {
        int[] freq = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] top;
        int deletions = 0;

        for (char c: s.toCharArray())
            freq[c - 'a']++;

        for (int i = 0; i < 26; i++)
            if (freq[i] > 0) pq.add(new int[]{i, freq[i]});

        int current = pq.peek()[1] + 1;

        while (pq.size() > 0)
        {
            top = pq.remove();
            if (top[1] == current)
            {
                deletions++;
                if (top[1] == 1) continue; // Needed to prevent freq going to 0 and negative
                pq.add(new int[]{top[0], top[1] - 1});
            }
            else
            {
                current = top[1];
            }
        }

        return deletions;
    }

    public int minDeletions(String s)
    {
        int[] freq = new int[26];
        int deletions = 0;

        for (char c: s.toCharArray())
            freq[c - 'a']++;

        Arrays.sort(freq);

        int current = freq[25];

        for (int i = 25; i >= 0 && freq[i] > 0; i--)
        {
            if (freq[i] > current)
            {
                deletions += (freq[i] - current);
                freq[i] = current;
            }
            current = Math.max(0, freq[i] - 1);
        }

        return deletions;
    }
}
