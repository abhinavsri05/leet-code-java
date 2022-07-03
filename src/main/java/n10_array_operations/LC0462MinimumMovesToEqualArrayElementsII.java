package n10_array_operations;

import java.util.Arrays;

public class LC0462MinimumMovesToEqualArrayElementsII
{
    // My intuition was to compute average and use that to find minimum number of moves
    // This does not work
    public int minMoves1(int[] nums)
    {
        int sum = 0;
        for (int n: nums)
            sum += n;
        int avg = (int)(sum * 1.0 / nums.length + 0.5);
        int moves = 0;

        for (int n: nums)
            moves += Math.abs(n - avg);

        return moves;
    }

    public int minMoves2(int[] nums)
    {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;

        for (int n: nums)
            moves += Math.abs(n - median);

        return moves;
    }
}
