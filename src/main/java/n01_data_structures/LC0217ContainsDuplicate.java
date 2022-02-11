package n01_data_structures;

import java.util.HashSet;

public class LC0217ContainsDuplicate
{
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums)
        {
            if (seen.contains(num)) return true;
            seen.add(num);
        }

        return false;

    }
}
