package n10_array_operations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0406QueueReconstructionByHeight
{
    public int[][] reconstructQueue(int[][] people)
    {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> output = new LinkedList<>();

        for (int[] p: people)
            output.add(p[1], p);

        return output.toArray(new int[people.length][2]);
    }
}
