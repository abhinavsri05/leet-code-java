package n08_bit_manipulation;/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */

public class LC0191NumberOfOneBits {
    // >>> is for calculating unsigned bits whereas >> is for signed bits
    public int hammingWeight(int n) {
        int s = 0;
        while (n != 0)
        {
            n = n & (n - 1);
            s++;
        }
        return s;
    }

    public static void main(String[] args) {
    }

}
