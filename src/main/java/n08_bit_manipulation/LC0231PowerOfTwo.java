package n08_bit_manipulation;

public class LC0231PowerOfTwo
{
    public boolean isPowerOfTwo(int n)
    {
        long x = n;
        return n > 0 && (x & x - 1) == 0;
        // return (x & (-x)) == x;
    }
}
