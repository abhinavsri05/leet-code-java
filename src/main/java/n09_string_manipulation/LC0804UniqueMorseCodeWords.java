package n09_string_manipulation;

import java.util.HashSet;

public class LC0804UniqueMorseCodeWords {
    private String getMorseCode(String word)
    {
        String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder code = new StringBuilder();

        for (char c: word.toCharArray())
        {
            code.append(morseCodes[c - 'a']);
        }

        return code.toString();
    }
    public int uniqueMorseRepresentations(String[] words)
    {
        HashSet<String> codes = new HashSet<>();

        for (String word: words)
        {
            codes.add(getMorseCode(word));
        }

        return codes.size();
    }
}
