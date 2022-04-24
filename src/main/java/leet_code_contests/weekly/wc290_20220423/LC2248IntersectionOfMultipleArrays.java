package leet_code_contests.weekly.wc290_20220423;

import java.util.LinkedList;
import java.util.List;

public class LC2248IntersectionOfMultipleArrays
{
    public List<Integer> intersection(int[][] nums) {
        int[] seen = new int[1001];
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[i].length; j++)
            {
                seen[nums[i][j]]++;
            }
        }

        for (int i = 1; i < 1001; i++)
        {
            if (seen[i] == nums.length)
                result.add(i);
        }

        return result;
    }
}
