package n09_string_manipulation;

public class P0383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] seen = new int[26];
        int i;

        int lengthMagazine = magazine.length();
        int lengthRansomNote = ransomNote.length();

        if (lengthMagazine < lengthRansomNote) return false;

        for (i = 0; i < lengthMagazine; i++)
        {
            seen[magazine.charAt(i) - 'a']++;
            if (i < lengthRansomNote) seen[ransomNote.charAt(i) - 'a']--;
        }

        for (int j: seen)
        {
            if (j < 0) return false;
        }

        return true;

    }
}
