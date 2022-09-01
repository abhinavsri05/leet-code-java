package n08_bit_manipulation;

public class LC0342PowerOfFour
{
    public boolean isPowerOfFour(int n) {
        // Negative numbers are NOT a power of a positive number
        // x & (x - 1) = 0 for a power of 2
        // Power of 4's have exactly 1 one and event of zeros (0, 2, 4, 6, ... on left)
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
