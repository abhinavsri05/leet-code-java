package n11_mathematical_operations;

public class LC0069Sqrt_x
{
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long lo = 1;
        long hi = x / 2;
        long mid;
        long curr;
        long next;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            curr = mid * mid;
            next = curr + 2 * mid + 1;
            if (curr == x || (curr < x && next > x))
                return (int)mid;

            if (curr < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return (int)lo;

    }
}
