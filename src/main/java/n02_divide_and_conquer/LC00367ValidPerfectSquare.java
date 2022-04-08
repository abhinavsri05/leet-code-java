package n02_divide_and_conquer;

public class LC00367ValidPerfectSquare
{
    public boolean isPerfectSquare(int num)
    {
        if (num <= 1) return true;
        long start = 2;
        long end = num / 2;
        long mid;
        long sq;

        while (start <= end)
        {
            mid = start + (end - start) / 2;
            sq = mid * mid * 1L;
            if (sq == num) return true;
            if (sq < num)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
