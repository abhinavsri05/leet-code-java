package n08_bit_manipulation;

import java.util.HashMap;

public class LC0318MaximumProductOfWordLengths
{
    // All based on LeetCode solutions
    // Attempt 1
    /*
        private int bitPosition(char ch)
    {
        return (int)ch - (int)'a';
    }

    private boolean noCommonLetter(String one, String two)
    {
        int bitsRepOne = 0, bitsRepTwo = 0;

        for (char ch: one.toCharArray())
            bitsRepOne = bitsRepOne | (1 << bitPosition(ch));

        for (char ch: two.toCharArray())
            bitsRepTwo = bitsRepTwo | (1 << bitPosition(ch));

        return (bitsRepOne & bitsRepTwo) == 0;
    }

    public int maxProduct(String[] words)
    {
        int maxProd = 0;
        int i, j;
        int n = words.length;

        for (i = 0; i < n - 1; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                if (noCommonLetter(words[i], words[j]))
                {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }

        return maxProd;
    }
     */
    private int getBitMap(String s)
    {
        int bitMap = 0;

        for (char ch: s.toCharArray())
            bitMap = bitMap | (1 << ((int)ch - (int)'a'));

        return bitMap;
    }

    public int maxProduct(String[] words)
    {
        int maxProd = 0;
        int len = words.length;
        int bitMap;
        int i;
        HashMap<Integer, Integer> maxLengthForABitMap = new HashMap<>();
        // For words with same letters keep the length of the longest one
        for (i = 0; i < len; i++)
        {
            bitMap = getBitMap(words[i]);
            maxLengthForABitMap.put(bitMap,
                    Math.max(maxLengthForABitMap.getOrDefault(bitMap, 0),
                            words[i].length()));
        }

        for (int x: maxLengthForABitMap.keySet())
        {
            for (int y: maxLengthForABitMap.keySet())
            {
                if ((x & y) == 0)
                    maxProd = Math.max(maxProd, maxLengthForABitMap.get(x) * maxLengthForABitMap.get(y));
            }
        }

        return maxProd;
    }

}
