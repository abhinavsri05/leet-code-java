package n11_mathematical_operations;

public class LC1359CountAllValidPickupAndDeliveryOptions {
    // Solution 1
    public int countOrders1(int n) {
        final int mod = 1_000_000_007;
        long count = 1;
        int i;

        for (i = 1; i <= n; i++)
        {
            count *= i * (2L * i - 1L);
            count %= mod;
        }

        return (int) count;

    }
}
