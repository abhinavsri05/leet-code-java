package n08_bit_manipulation;

public class LC1461CheckIfAStringContainsAllBinaryCodesOfSizeK
{
    public boolean hasAllCodes(String s, int k)
    {
        int need = 1 << k; // 2^k
        boolean[] found = new boolean[need];
        int hash = 0;
        int allOnes = need - 1;

        for (int i = 0; i < s.length(); i++)
        {
            // Calculate Hash in O(1)
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');

            if (i >= k - 1 && !found[hash])
            {
                found[hash] = true;
                need--;
                if (need == 0) return true;
            }
        }

        return false;
    }
}
