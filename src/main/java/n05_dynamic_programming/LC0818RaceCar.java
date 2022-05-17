package n05_dynamic_programming;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LC0818RaceCar
{
    // Using BFS
    public int racecar(int target) {
        Deque<int[]> q = new LinkedList<>();
        int[] top;
        HashSet<String> visited = new HashSet<>();
        String key;

        int speed, posn;
        q.add(new int[]{0, 1, 0}); // {position, speed, steps from start}
        visited.add(0 + ":" + 1);

        while (!q.isEmpty())
        {
            top = q.poll();

            if (top[0] + top[1] == target || top[0] == target)
                return top[2] + 1;

            // Accelerate

            posn = top[0] + top[1];
            speed = 2 * top[1];
            key = posn + ":" + speed;

            // Check https://leetcode.com/problems/race-car/discuss/124326/Summary-of-the-BFS-and-DP-solutions-with-intuitive-explanation for pruning logic
            if (!visited.contains(key) && posn > 0 && posn < 2 * target) // Why 2 * target
            {
                q.add(new int[]{posn, speed, top[2] + 1});
                visited.add(key);
            }

            // Reverse
            posn = top[0];
            speed = top[1] > 0 ? -1 : 1;
            key = posn + ":" + speed;

            if (!visited.contains(key) && posn > 0 && posn < 2 * target) // Why 2 * target
            {
                q.add(new int[]{posn, speed, top[2] + 1});
                visited.add(key);
            }
        }

        return -1;

    }

    // Using DFS
}
