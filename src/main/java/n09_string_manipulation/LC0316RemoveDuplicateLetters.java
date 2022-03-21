package n09_string_manipulation;

public class LC0316RemoveDuplicateLetters {
    // LC Solution - 1 (Greedy recursive approach)
    public String removeDuplicateLetters(String s)
    {
        int[] charsIn = new int[26];
        int pos = 0;

        for (char c: s.toCharArray())
            charsIn[c - 'a']++;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--charsIn[s.charAt(i) - 'a'] == 0) break;
        }

        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
