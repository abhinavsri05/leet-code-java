package n09_string_manipulation;

public class P0242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26]; // Given that both strings contain lower case letters.
        int i;
        int chIdx;

        if (s.length() != t.length()) return false;

        for (i = 0; i < s.length(); i++)
        {
            chIdx = s.charAt(i) - 'a';
            chars[chIdx]++;
            chIdx = t.charAt(i) - 'a';
            chars[chIdx]--;
        }

        for (i = 0; i < 26; i++)
        {
            if (chars[i] != 0) return false;
        }


        return true;

    }

    /*

    What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

    Use HashTable

     */
}
