package n05_dynamic_programming;

import java.util.HashMap;

public class LC0003LongestSubstringWithoutRepeatingCharacters {

//    public int lengthOfLongestSubstring(String s)
//    {
//        HashMap<Character, Integer> seen = new HashMap<>();
//
//        int n = s.length();
//
//        int[] lengthSubstring = new int[n + 1];
//        lengthSubstring[0] = 0;
//        int i, maxLength = 0;
//        char ch;
//
//        for (i = 1; i <= n; i++)
//        {
//            ch = s.charAt(i - 1);
//            if (!seen.containsKey(ch))
//            {
//                // System.out.println("Does not contain " + ch);
//                lengthSubstring[i] = lengthSubstring[i - 1] + 1;
//                seen.put(ch, i);
//            }
//            else
//            {
//                // System.out.println("Contains " + ch);
//                lengthSubstring[i] = Math.min(i - seen.get(ch), lengthSubstring[i - 1] + 1) ; // Second part added for input like abba
//                seen.put(ch, i);
//            }
//
//
//            if (lengthSubstring[i] > maxLength)
//            {
//                maxLength = lengthSubstring[i];
//            }
//        }
//
//        return maxLength;
//
//    }
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> seen = new HashMap<>();
        int lengthSubstringPrev = 0;
        int lengthSubstringCurr;
        int i, maxLength = 0;
        char ch;

        for (i = 1; i <= s.length(); i++)
        {
            ch = s.charAt(i - 1);
            if (!seen.containsKey(ch))
                lengthSubstringCurr = lengthSubstringPrev + 1;
            else
                lengthSubstringCurr = Math.min(i - seen.get(ch), lengthSubstringPrev + 1) ; // Second part added for input like abba

            seen.put(ch, i);
            maxLength = Math.max(maxLength, lengthSubstringCurr);
            lengthSubstringPrev = lengthSubstringCurr;
        }

        return maxLength;

    }
}
