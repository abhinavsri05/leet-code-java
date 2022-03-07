package n05_dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LC0740DeleteAndEarn {
    public int deleteAndEarn(int[] nums)
    {

        HashMap<Integer, Integer> pts = new HashMap<>();

        // Compute points asssociated with each number in nums

        for (int n: nums)
        {
            pts.put(n, pts.getOrDefault(n, 0) + n);
        }

        // Get list of unique numbers in num

        ArrayList<Integer> ele = new ArrayList<>(pts.keySet());
        Collections.sort(ele);

        int maxPoints_curr = pts.get(ele.get(0));
        int maxPoints_curr_minus_1 = 0;
        int i;

        int curr;
        int temp;

        for (i = 1; i < ele.size(); i++)
        {
            temp = maxPoints_curr;
            curr = ele.get(i);
            if (curr == ele.get(i - 1) + 1)
                maxPoints_curr = Math.max(maxPoints_curr, maxPoints_curr_minus_1 +  pts.get(curr));
            else
                maxPoints_curr += pts.get(curr);
            maxPoints_curr_minus_1 = temp;
        }
        return maxPoints_curr;
    }
}
