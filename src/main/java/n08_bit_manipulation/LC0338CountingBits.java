package n08_bit_manipulation;

public class LC0338CountingBits {
//    DP + Most Significant Bit
    public int[] countBits1(int n)
    {
        int[] output = new int[n + 1];
        int powerOfTwo = 1;
        int i = 0;

        while (powerOfTwo <= n)
        {
            while (i < powerOfTwo && i + powerOfTwo <= n)
            {
                output[powerOfTwo + i] = output[i] + 1;
                i++;
            }
            powerOfTwo <<= 1;
            i = 0;
        }
        return output;
    }

//    DP + Least Significant Bit

    public int[] countBits2(int n)
    {
        int[] output = new int[n + 1];
        int i = 0;

        for (i = 1; i <= n; i++)
        {
            output[i] = output[i >> 1] + (i & 1);
        }
        return output;
    }

//    DP + Last Set Bit
    public int[] countBits3(int n)
    {
        int[] output = new int[n + 1];
        int i = 0;

        for (i = 1; i <= n; i++)
        {
            output[i] = output[i & (i - 1)] + 1;
        }
        return output;
    }
}
