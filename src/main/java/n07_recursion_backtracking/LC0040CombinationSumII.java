package n07_recursion_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0040CombinationSumII
{
    // Attempt 1
    LinkedList<List<Integer>> output;
    LinkedList<Integer> temp;
    int[] candidates;
    int target;

    private void backtrack(int start, int runningSum)
    {
        if (start == candidates.length) return;

        for (int i = start; i < candidates.length; i++)
        {
            if ((i > start && candidates[i] == candidates[i - 1]) || (runningSum + candidates[i] > target))
                continue;
            if (runningSum + candidates[i] == target)
            {
                temp.addLast(candidates[i]);
                output.add(new LinkedList(temp));
                temp.removeLast();
            }
            else
            {
                temp.addLast(candidates[i]);
                backtrack(i + 1, runningSum + candidates[i]);
                temp.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        this.output = new LinkedList<>();
        this.temp = new LinkedList<>();
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(candidates);

        backtrack(0, 0);

        return output;
    }
}
