package leet_code_contests.weekly.wc282_20220226;

public class LC2185CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int l = pref.length();
        int count = 0;

        for (String word: words)
        {

            if(word.length() >= l && word.substring(0, l).equals(pref)) count++;
        }

        return count;

    }
}
