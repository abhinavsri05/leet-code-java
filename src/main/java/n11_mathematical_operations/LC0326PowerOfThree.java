package n11_mathematical_operations;

public class LC0326PowerOfThree
{
    public boolean isPowerOfThree(int n)
    {
        while (n > 1 && n % 3 == 0)
            n /= 3;
        return n == 1;
    }
}
