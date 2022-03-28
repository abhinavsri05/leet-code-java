package leet_code_contests.weekly.wc286_20220326;

public class LC2216MinimumDeletionsToMakeArrayBeautiful
{
    public int minDeletion1(int[] nums)
    {
        boolean evenDel = true;
        int rem;
        int n = nums.length;
        int count = 0;

        for (int i = 1; i < n; i++)
        {
            rem = evenDel ? 0 : 1; // count can be used in place of evenDel

            if ((i - 1) % 2 == rem)
            {
                if (nums[i - 1] == nums[i])
                {
                    evenDel = true ^ evenDel;
                    count++;
                }
            }
        }

        if ((n - count) % 2 == 1)
            count++;

        return count;
    }

    // Attempt 2
    public int minDeletion(int[] nums)
    {
        int rem;
        int n = nums.length;
        int count = 0;

        for (int i = 1; i < n; i++)
        {
            if ((i - 1) % 2 == count % 2 && nums[i - 1] == nums[i])
                count++;
        }

        if ((n - count) % 2 == 1)
            count++;

        return count;
    }
}
