package n09_string_manipulation;

import java.util.LinkedList;
import java.util.List;

public class LC0763PartitionLabels {
    //Attempt 1: 3/20
    public List<Integer> partitionLabels(String s) {
        int[] lastPosn = new int[26];
        List<Integer> output = new LinkedList<>();
        int maxTillNow = 0;
        int start = 0;
        char[] ch = s.toCharArray();
        int i;

        for (i = 0; i < s.length(); i++)
        {
            lastPosn[ch[i] - 'a'] = i;
        }

        for (i = 0; i < s.length(); i++)
        {
            if (lastPosn[ch[i] - 'a'] == i && i == maxTillNow)
            {
                output.add(i - start + 1);
                start = i + 1;
                maxTillNow = i + 1;
            }
            else
            {
                maxTillNow = Math.max(lastPosn[ch[i] - 'a'], maxTillNow);
            }
        }

        return output;
    }

}
