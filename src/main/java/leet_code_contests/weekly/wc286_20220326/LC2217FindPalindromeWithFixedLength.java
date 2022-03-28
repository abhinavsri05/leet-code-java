package leet_code_contests.weekly.wc286_20220326;

public class LC2217FindPalindromeWithFixedLength
{
    // Attempt during the contest
    /*
    ArrayList<Long> palindromes;
    char[] temp;

    long generatePalindrome(int length, int k)
    {
        // System.out.println(length + ", " + k);
        char[] num = new char[length];
        int val;
        int offset = 0;
        boolean start = true;
        while ((length % 2 == 0 && offset < length / 2) || (length % 2 == 1 && offset <= length / 2))
        {
            val = k % 10;
            val = ((length % 2 == 0 && offset == length / 2 - 1) || (length % 2 == 1 && offset == length / 2)) ? val + 1 : val;
            System.out.println(val);
            if (length % 2 == 0)
            {
                if (start)
                {
                    num[length / 2 + offset] = (char)(val + '0');
                    num[length / 2 - 1 - offset] = (char)(val + '0');
                    start = false;
                }
                else
                {
                    num[length / 2 + offset] = (char)(val + '0');
                    num[length / 2 - 1 - offset] = (char)(val + '0');
                }

            }
            else
            {
                if (start)
                {
                    num[length / 2 - offset] = (char)(val + '0');
                    start = false;
                }
                else
                {
                    num[length / 2 - offset] = (char)(val + '0');
                    num[length / 2 + offset] = (char)(val + '0');
                }
            }
            k = k / 10;
            offset ++;
        }

        // System.out.println(k);
        long ret = Long.parseLong(new String(num));
        // System.out.println(ret);

        return k == 0 ? ret : -1;
    }


    void generate(int start, int end)
    {
        if (start > end)
        {
            palindromes.add(Long.parseLong(new String(temp)));
            return;
        }

        for (int i = 0; i <= 9; i++)
        {
            if (i == 0 && start == 0)
                continue;
            temp[start] = (char)(i + '0');
            temp[end] = temp[start];
            generate(start + 1, end - 1);

        }
    }


    public long[] kthPalindrome(int[] queries, int intLength) {
        palindromes = new ArrayList<>();
        temp = new char[intLength];
        int n = queries.length;
        long[] output = new long[n];

        generate(0, intLength - 1);

        // System.out.println(Arrays.toString(palindromes.toArray()));

        long l = palindromes.size();
        l = 9;
        for (int j = 1; j < intLength; j++)
        {
            if (j == intLength - 1)
                l *=9;
            else
                l*=10;
        }

        for (int i = 0; i < n; i++)
        {
            // if (queries[i] <= l)
            //     output[i] = palindromes.get(queries[i] - 1);
            // else
            //     output[i] = -1L;
            if (queries[i] > l)
                output[i] = -1;
            else
                output[i] = generatePalindrome(intLength, queries[i] - 1);
        }
        return output;

    }
     */

    /*
    These are the three digit palindromes-
    101
    111
    121
    131
    141
    151
    161
    171
    181
    191
    202
    212
    222
    232
    242
    ...
    999
    So, the first two digits (half) form a series starting 10
     */

    private long generatePalindrome(boolean isOddLength, long leftHalf)
    {
        StringBuilder palindrome = new StringBuilder(String.valueOf(leftHalf));
        if (isOddLength) leftHalf = leftHalf / 10l;
        while (leftHalf > 0L)
        {
            palindrome.append(leftHalf % 10L);
            leftHalf /= 10L;
        }
        return Long.parseLong(palindrome.toString());
    }


    public long[] kthPalindrome(int[] queries, int intLength)
    {
        int n = queries.length;
        long[] output = new long[n];

        long totalPossible = (long) Math.pow(10, (int) Math.floor((intLength + 1) / 2) - 1);

        for (int i = 0; i < n; i++)
        {
            if (queries[i] > totalPossible * 9L)
                output[i] = -1L;
            else
                output[i] = generatePalindrome((intLength & 1) == 1, totalPossible + queries[i] - 1);
        }
        return output;
    }
}
