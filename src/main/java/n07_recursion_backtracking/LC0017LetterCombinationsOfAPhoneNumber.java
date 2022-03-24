package n07_recursion_backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC0017LetterCombinationsOfAPhoneNumber {
    private void backtrack(HashMap<Character, List<Character>> keys,
                           List<String> output,
                           char[] temp,
                           String digits,
                           int n,
                           int index)
    {
        if (index == n)
        {
            output.add(new String(temp));
            return;
        }

        for (char c: keys.get(digits.charAt(index)))
        {
            temp[index] = c;
            backtrack(keys, output, temp, digits, n, index + 1);
        }
    }

    public List<String> letterCombinations(String digits)
    {
        if (digits.equals("")) return new LinkedList<String>();
        HashMap<Character, List<Character>> keys = new HashMap<>();

        keys.put('2', List.of('a', 'b', 'c'));
        keys.put('3', List.of('d', 'e', 'f'));
        keys.put('4', List.of('g', 'h', 'i'));
        keys.put('5', List.of('j', 'k', 'l'));
        keys.put('6', List.of('m', 'n', 'o'));
        keys.put('7', List.of('p', 'q', 'r', 's'));
        keys.put('8', List.of('t', 'u', 'v'));
        keys.put('9', List.of('w', 'x', 'y', 'z'));

        // Alternate initialization of HashMap
        /*
         private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        and the use toCharArray() to iterate over each value
         */

        List<String> output = new LinkedList<>();
        char[] temp = new char[digits.length()];

        backtrack(keys, output, temp, digits, digits.length(), 0);

        return output;

    }
}
