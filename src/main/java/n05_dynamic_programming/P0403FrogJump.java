package n05_dynamic_programming;/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 */

public class P0403FrogJump
{
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] possible = new boolean[n][n + 1];  // Maximum jump size possible is n

        /* Initialize all with False */

        /*
        Stone:     1  2  4  7  11
        Max Jump:  1  2  3  4  5
         */
        int distance, i, j;

        possible[0][1] = true; // Jump of length 1 possible from 0th stone

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                distance = stones[i] - stones[j];  // We want jump of distance from jth stone

                if (distance <= n && possible[j][distance]) {
                    possible[i][distance] = true;
                    if (distance - 1 >= 0) possible[i][distance - 1] = true;
                    if (distance + 1 <= n) possible[i][distance + 1] = true;
                }
            }
        }
        boolean result = false;

        for (i = 0; i < n; i++)
            result = result || possible[n - 1][i];

        return result;

    }


}
