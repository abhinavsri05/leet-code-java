package n10_array_operations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0438FindAlAnagramsInAString {

    // Attempt 1
    private boolean same(int[] a, int[] b)
    {
        for (int i = 0; i < 26; i++)
        {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int pLength = p.length();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        List<Integer> output = new LinkedList<>();

        for (i = 0; i < pLength; i++)
        {
            pFreq[p.charAt(i) - 'a']++;
        }

        for (i = 0; i < s.length(); i++)
        {
            sFreq[s.charAt(i) - 'a']++;
            if (i >= pLength - 1)
            {
                if (i - pLength >= 0) sFreq[s.charAt(i - pLength) - 'a']--;
                if (same(pFreq, sFreq)) output.add(i - pLength + 1);
            }
        }
        return output;
    }

    // Attempt 2

    public List<Integer> findAnagrams2(String s, String p) {
        int i = 0;
        int pLength = p.length();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        List<Integer> output = new LinkedList<>();

        for (i = 0; i < pLength; i++)
        {
            pFreq[p.charAt(i) - 'a']++;
        }

        for (i = 0; i < s.length(); i++)
        {
            sFreq[s.charAt(i) - 'a']++;
            if (i >= pLength - 1)
            {
                if (i - pLength >= 0) sFreq[s.charAt(i - pLength) - 'a']--;
                if (Arrays.equals(pFreq, sFreq)) output.add(i - pLength + 1);
            }
        }
        return output;
    }
}
