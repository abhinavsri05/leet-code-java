package n11_mathematical_operations;

public class LC2180CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int ret = 0;
        int sum;
        int temp;
        for (int i = 1; i <= num; i++)
        {
            sum = 0;
            temp = i;
            while (temp > 0)
            {
                sum += temp % 10;
                temp /= 10;
            }
            if ((sum & 1) == 0)
                ret++;
        }
        return ret;

    }
}
