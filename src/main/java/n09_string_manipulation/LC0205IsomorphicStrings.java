package n09_string_manipulation;

import java.util.HashMap;
import java.util.HashSet;

public class LC0205IsomorphicStrings
{
    // Using symbol tables/hashing
    public boolean isIsomorphic1(String s, String t)
    {
        HashMap<Character, Character> mapping = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++)
        {
            if (mapping.containsKey(s.charAt(i)))
            {    if (t.charAt(i) != mapping.get(s.charAt(i)))
                return false;
            }
            else
            {
                if (used.contains(t.charAt(i)))
                    return false;
                mapping.put(s.charAt(i), t.charAt(i));
                used.add(t.charAt(i));
            }
        }
        return true;
    }

    // Using 2 arrays
    public boolean isIsomorphic2(String s, String t)
    {
        int[] mapping = new int[256]; // since only valid ascii characters
        int[] reverseMapping = new int[256];

        int sLen = s.length();
        int tLen = t.length();

        if (sLen != tLen)
            return false;

        char sChar, tChar;

        for (int i = 0; i < sLen; i++)
        {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            if (mapping[sChar] > 0 && mapping[sChar] != (tChar + 1)) return false;
            if (mapping[sChar] == 0)
            {
                if (reverseMapping[tChar] != 0) return false;
                mapping[sChar] = tChar + 1;
                reverseMapping[tChar] = sChar + 1;
            }
        }
        return true;
    }

    // Using 1 array and bit manipulation
    public boolean isIsomorphic(String s, String t)
    {
        int[] mapping = new int[256]; // since only valid ascii characters

        int sLen = s.length();
        int tLen = t.length();

        if (sLen != tLen)
            return false;

        char sChar, tChar;

        for (int i = 0; i < sLen; i++)
        {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            if ((mapping[sChar] & 511) > 0 && (mapping[sChar] & 511) != (tChar + 1)) return false;
            if ((mapping[sChar] & 511) == 0)
            {
                if (mapping[tChar] >> 9 != 0) return false;
                mapping[sChar] += tChar + 1;
                mapping[tChar] += (sChar + 1) << 9;
            }
        }
        return true;
    }
}
