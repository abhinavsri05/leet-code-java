package n11_mathematical_operations;

import java.util.HashSet;

public class LC0202HappyNumber {
    // Attempt 1

    private int replacement(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }
    public boolean isHappy1(int n)
    {
        HashSet<Integer> seen = new HashSet<>();
        while (n > 3 && !seen.contains(n))
        {
            seen.add(n);
            n = replacement(n);
        }

        return n == 1;

    }

    // Using cycle detection
    public boolean isHappy(int n)
    {
        int slow = n;
        int fast = replacement(replacement(n));

        while (fast > 3 && slow != fast)
        {
            slow = replacement(slow);
            fast = replacement(replacement(fast));
        }

        return fast == 1;
    }

    // Attempt 3
    public boolean isHappy2(int n)
    {
        while (n > 4) // 1, 2, 3 is fine but 4 never reached single digit
            n = replacement(n);
        return n == 1;
    }
}
