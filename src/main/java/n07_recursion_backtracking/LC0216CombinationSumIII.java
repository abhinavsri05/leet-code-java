package n07_recursion_backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0216CombinationSumIII
{
    private void backtrack(List<List<Integer>> output, List<Integer> temp, int start, int dig, int sum, int k, int n)
    {
        if (dig > k) return;
        int i;
        for (i = start; i < 10; i++)
        {
            if (sum + i < n)
            {
                temp.add(i);
                backtrack(output, temp, i + 1, dig + 1, sum + i, k, n);
                temp.remove(dig - 1);
            }
            if (sum + i == n)
            {
                if (dig == k)
                {
                    temp.add(i);
                    output.add(new LinkedList<>(temp));
                    temp.remove(dig - 1);
                }
                break;
            }
            if (sum + i > n)
                break;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();

        backtrack(output, temp, 1, 1, 0, k, n);

        return output;
    }
}
