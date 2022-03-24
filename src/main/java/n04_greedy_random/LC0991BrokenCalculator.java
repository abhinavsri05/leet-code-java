package n04_greedy_random;

import java.util.LinkedList;

public class LC0991BrokenCalculator {
    // Attempt 1 (Time exceeded)
    public int brokenCalc1(int startValue, int target) {
        LinkedList<int[]> ops = new LinkedList<>();

        ops.add(new int[]{startValue, 0});
        int[] ele = new int[2];

        while (!ops.isEmpty())
        {
            ele = ops.remove();
            if (ele[0] == target) break;

            ops.add(new int[]{ele[0] * 2, ele[1] + 1});
            ops.add(new int[]{ele[0] - 1, ele[1] + 1});
        }

        return ele[1];
    }
    // LeetCode Solution
    public int brokenCalc(int startValue, int target) {

        int steps = 0;

        while (target > startValue)
        {
            steps++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }
        return steps + startValue - target;
    }
}
