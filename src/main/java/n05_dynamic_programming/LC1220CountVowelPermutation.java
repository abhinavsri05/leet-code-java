package n05_dynamic_programming;

public class LC1220CountVowelPermutation
{
    // Linear space
    public int countVowelPermutation1(int n)
    {
        // initialize dp table

        long[] a = new long[n];
        long[] e = new long[n];
        long[] i = new long[n];
        long[] o = new long[n];
        long[] u = new long[n];

        final int MOD = 1_000_000_007;

        // Only one single length string possible for each vowel

        a[0] = 1L;
        e[0] = 1L;
        i[0] = 1L;
        o[0] = 1L;
        u[0] = 1L;

        // Use the state machine to determine number of string of length x given counts for x - 1.

        // For example, since e is followed by a and i, the number of string starting with e and length x = number of string of length x - 1 starting with a + numner of string of length x - 1 starting with i

        for (int x = 1; x < n; x++)
        {
            a[x] = e[x - 1];
            e[x] = (a[x - 1] + i[x - 1]) % MOD;
            i[x] = (a[x - 1] + e[x - 1] + o[x - 1] + u[x - 1]) % MOD;
            o[x] = (i[x - 1] + u[x - 1]) % MOD;
            u[x] = a[x - 1];
        }

        return (int)((a[n - 1] + e[n - 1] + i[n - 1] + o[n - 1] + u[n - 1]) % MOD);
    }

    // Constant Space
    public int countVowelPermutation(int n)
    {
        // initialize dp table

        long[] a = new long[2];
        long[] e = new long[2];
        long[] i = new long[2];
        long[] o = new long[2];
        long[] u = new long[2];

        final int MOD = 1_000_000_007;

        // Only one single length string possible for each vowel

        a[0] = 1L;
        e[0] = 1L;
        i[0] = 1L;
        o[0] = 1L;
        u[0] = 1L;

        // Use the state machine to determine number of string of length x given counts for x - 1.

        // For example, since e is followed by a and i, the number of string starting with e and length x = number of string of length x - 1 starting with a + number of string of length x - 1 starting with i
        int curr = 0;
        int prev = 0;
        for (int x = 1; x < n; x++)
        {
            curr = (x & 1);
            a[curr] = e[prev];
            e[curr] = (a[prev] + i[prev]) % MOD;
            i[curr] = (a[prev] + e[prev] + o[prev] + u[prev]) % MOD;
            o[curr] = (i[prev] + u[prev]) % MOD;
            u[curr] = a[prev];
            prev = curr;
        }

        return (int)((a[curr] + e[curr] + i[curr] + o[curr] + u[curr]) % MOD);


    }
}
