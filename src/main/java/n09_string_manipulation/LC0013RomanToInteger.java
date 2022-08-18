package n09_string_manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC0013RomanToInteger
{
    public int romanToInt(String s) {
        HashMap<Character, Integer> mapping = new HashMap<>();
        HashMap<Character, HashSet<Character>> negatives = new HashMap<>();

        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        negatives.put('I', new HashSet<>(Arrays.asList('V', 'X')));
        negatives.put('X', new HashSet<>(Arrays.asList('L', 'C')));
        negatives.put('C', new HashSet<>(Arrays.asList('D', 'M')));

        int num = 0;
        char prev = ' ';

        for (char c: s.toCharArray())
        {
            if (prev != ' ' && negatives.containsKey(prev) && negatives.get(prev).contains(c))
            {
                num -= 2 * mapping.get(prev); // 2x since we already added the number last time
            }
            num += mapping.get(c);
            prev = c;
        }

        return num;
    }
}
