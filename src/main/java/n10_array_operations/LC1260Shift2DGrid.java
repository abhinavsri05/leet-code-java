package n10_array_operations;

import java.util.ArrayList;
import java.util.List;

public class LC1260Shift2DGrid
{
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        k = k % (r * c);
        k = r * c - k;

        for (int i = 0; i < r * c; i++)
        {
            if (i > 0 && i % c == 0)
            {
                output.add(row);
                row = new ArrayList<>();
            }
            row.add(grid[((i + k) / c) % r][(i + k) % c]);
        }
        output.add(row);

        return output;

    }
}
