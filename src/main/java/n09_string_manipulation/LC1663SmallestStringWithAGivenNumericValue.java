package n09_string_manipulation;

public class LC1663SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        // StringBuilder ret = new StringBuilder(n);
        /*
        Using StringBuilder here is very slow. String builder took over 100 times mote time than using char array.
         */
        char[] ret = new char[n];

        int val;

        for (int i = 1; i <= n; i++)
        {
            val = k - n + i <= 26 ? k - n + i : 26; // This is Math.min()
            ret[n - i]  = (char)(val + 96);
            // Prev line would have been ret.insert(0, (char)(val + 96)) in case pof StringBuilder
            k -= val;
        }

        return new String(ret);

    }
}
