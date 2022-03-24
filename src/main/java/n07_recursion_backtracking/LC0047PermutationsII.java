package n07_recursion_backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC0047PermutationsII
{
    // Attempt 1: Does NOT work
    /*

    LinkedList<List<Integer>> output;
    ArrayList<Integer> temp;
    int[] nums;
    int n;

    void backtrack(int start)
    {
        if (start == n)
        {
            output.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i < n; i++)
        {
            if (i > start && nums[i] == nums[i - 1]) continue;
            Collections.swap(temp, start, i);
            backtrack(start + 1);
            Collections.swap(temp, start, i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        this.output = new LinkedList<>();
        this.temp = new ArrayList<Integer>();
        this.nums = nums;
        this.n = nums.length;
        // Arrays.sort(nums);
        for (int num: nums)
            temp.add(num);
        backtrack(0);
        return output;
    }

    */

    LinkedList<List<Integer>> output;
    LinkedList<Integer> temp;
    HashMap<Integer, Integer> counts = new HashMap<>();
    int n;

    void backtrack(int start)
    {
        if (start == n)
        {
            output.add(new LinkedList<>(temp));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
        {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            temp.add(num);
            counts.put(num, count - 1);
            backtrack(start + 1);
            temp.removeLast();
            counts.put(num, count);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        this.output = new LinkedList<>();
        this.temp = new LinkedList<Integer>();
        this.n = nums.length;
        for (int num: nums)
        {
            if (counts.containsKey(num))
                counts.put(num, counts.get(num) + 1);
            else
                counts.put(num, 1);
        }
        backtrack(0);
        return output;
    }

}
