package n01_data_structures;

import java.util.HashMap;

public class LC0290WordPattern
{
    // Bijection means one-to-one mapping
    public boolean wordPattern1(String pattern, String s)
    {
        String[] splits = s.split(" ");
        HashMap<Character, String> mapping = new HashMap<>();
        HashMap<String, Character> reverseMapping = new HashMap<>();

        if (pattern.length() != splits.length) return false;

        for (int i = 0; i < pattern.length(); i++)
        {
            if (!mapping.containsKey(pattern.charAt(i)) && !reverseMapping.containsKey(splits[i]))
            {
                mapping.put(pattern.charAt(i), splits[i]);
                reverseMapping.put(splits[i], pattern.charAt(i));
                continue;
            }
            if (!mapping.getOrDefault(pattern.charAt(i), "").equals(splits[i]) || reverseMapping.getOrDefault(splits[i], ' ') != pattern.charAt(i))
            {
                return false;
            }
        }

        return true;
    }

    public boolean wordPattern(String pattern, String s)
    {
        String[] splits = s.split(" ");
        HashMap<Character, String> mapping = new HashMap<>();
        boolean containsKey;

        if (pattern.length() != splits.length) return false;

        for (int i = 0; i < pattern.length(); i++)
        {
            containsKey = mapping.containsKey(pattern.charAt(i));
            if (!mapping.containsValue(splits[i]) && !containsKey)
            {
                mapping.put(pattern.charAt(i), splits[i]);
                continue;
            }
            if (!containsKey || !mapping.containsValue(splits[i]) || !mapping.get(pattern.charAt(i)).equals(splits[i]))
                return false;
        }

        return true;
    }
}
