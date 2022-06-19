package n05_dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;

public class LC1048LongestStringChain
{
    public int longestStrChain(String[] words)
    {
        Arrays.sort(words, (i, j) -> i.length() - j.length());

        HashMap<String, Integer> dp = new HashMap<>();

        int longestWordSequenceLength = 1;

        for (String word : words)
        {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
}
