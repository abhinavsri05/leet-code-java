package n09_string_manipulation;

public class LC0387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s)
    {
        int[] frequency = new int[26];
        int len = s.length();
        int i;

        for (i = 0; i < len; i++)
        {
            frequency[s.charAt(i) - 'a']++;
        }

        for (i = 0; i < len; i++)
        {
            if (frequency[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
