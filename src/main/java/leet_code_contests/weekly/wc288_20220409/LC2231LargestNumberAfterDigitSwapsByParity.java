package leet_code_contests.weekly.wc288_20220409;

import java.util.ArrayList;
import java.util.Collections;

public class LC2231LargestNumberAfterDigitSwapsByParity
{
    public int largestInteger(int num) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        StringBuilder rev = new StringBuilder();
        int dig = 0;
        while (num > 0)
        {
            dig = num % 10;
            rev.append(dig);
            if (dig % 2 == 0)
                even.add(dig);
            else
                odd.add(dig);
            num /= 10;
        }
        // System.out.println(rev);
        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());
        int e = 0;
        int o = 0;
        num = 0;
        for (int i = rev.length() - 1; i >= 0; i--)
        {
            dig = rev.charAt(i) - '0';
            // System.out.println(dig);
            if (dig % 2 == 0)
                num = num * 10 + even.get(e++);
            else
                num = num * 10 + odd.get(o++);
        }
        return num;
    }
}
