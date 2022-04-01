package n11_mathematical_operations;

public class LC0343IntegerBreak
{
    // LeetCode solution from discussion
    /*
    special situations:
    n = 2, ans = 1x1
        n = 3, ans = 1x2
    general situations:
    n = 3xc , ans = 3^c
        n = 3xc+1 , ans = 3^(c-1)x4 (because we don't want to x1, for example n = 4, ans = 2x2 not 3x1)
        n = 3xc+2 , ans = 3^cx2

     */
    public int integerBreak(int n)
    {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int dividend = n / 3;
        int ret = 0;

        switch (n % 3)
        {
            case 0:
                ret = (int) Math.pow(3, dividend);
                break;
            case 1:
                ret = (int) Math.pow(3, dividend - 1) * 4;
                break;
            case 2:
                ret = (int) Math.pow(3, dividend) * 2;
                break;
        }

        return ret;

    }

}
