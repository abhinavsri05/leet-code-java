package n05_dynamic_programming;

public class LC0045JumpGameII
{
    public int jump(int[] nums)
    {
        int minJumps = 0;
        int maxIndexReacheable = 0;
        int maxReacheableCurrently = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            maxIndexReacheable = Math.max(maxIndexReacheable, i + nums[i]);

            if (i == maxReacheableCurrently)
            {
                minJumps++;
                maxReacheableCurrently = maxIndexReacheable;
            }
        }

        return minJumps;
    }
}
