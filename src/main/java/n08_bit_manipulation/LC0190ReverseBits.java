package n08_bit_manipulation;

public class LC0190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;

        for (int pow = 31; pow >= 0; pow--)
        {
            rev += (n & 1) << pow;
            n = n >> 1;
        }

        return rev;

    }
}
