package n09_string_manipulation;

public class P0567PermutationInString {
    public boolean checkInclusion(String s1, String s2)
    {
        int[] s1Freq = new int[26]; // Given only lowercase letters
        int[] s1Ins2Freq;
        int i, j;
        boolean found;
        for (i = 0; i < s1.length(); i++)
        {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        for (i = 0; i <= s2.length() - s1.length(); i++)
        {
            s1Ins2Freq = new int[26];
            for(j = 0; j < s1.length(); j++)
            {
                s1Ins2Freq[s2.charAt(i+j) - 'a']++;
            }
            found = checkFrequency(s1Freq, s1Ins2Freq);
            if(found) return true;
        }
        return false;
    }

    private boolean checkFrequency(int[] s1Freq, int[] s1Ins2Freq)
    {
        for (int i = 0; i < 26; i++)
        {
            if (s1Freq[i] != s1Ins2Freq[i])
                return false;
        }
        return true;
    }
}
