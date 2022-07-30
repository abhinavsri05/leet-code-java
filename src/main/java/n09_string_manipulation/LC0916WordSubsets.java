package n09_string_manipulation;

import java.util.LinkedList;
import java.util.List;

public class LC0916WordSubsets
{
    public List<String> wordSubsets(String[] words1, String[] words2)
    {
        List<String> output = new LinkedList<>();
        int[] subsetCombined = new int[26];

        for (String s: words2)
        {
            int[] sFreq = new int[26];

            for (char c: s.toCharArray())
                sFreq[c - 'a']++;

            for (int i = 0; i < 26; i++)
                subsetCombined[i] = Math.max(subsetCombined[i], sFreq[i]);
        }

        next:
        for (String s: words1)
        {
            int[] wFreq = new int[26];

            for (char c: s.toCharArray())
                wFreq[c - 'a']++;

            for (int i = 0; i < 26; i++)
            {
                if (subsetCombined[i] - wFreq[i] > 0) continue next;
            }

            output.add(s);
        }

        return output;

    }


}
