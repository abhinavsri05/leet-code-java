package n10_array_operations;

import java.util.ArrayList;
import java.util.List;

public class LC0456_132Pattern
{
    // Brute Force - time exceeded
//    public boolean find132pattern(int[] nums)
//    {
//        int n = nums.length;
//
//        for (int i = 0; i < n - 2; i++)
//        {
//            for (int j = i + 1; j < n - 1; j++)
//            {
//                for (int k = j + 1; k < n; k++)
//                {
//                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
//                }
//            }
//        }
//        return false;
//    }
    // Optimized brute force - times out
//    public boolean find132pattern(int[] nums)
//    {
//        int n = nums.length;
//
//        for (int i = 0; i < n - 2; i++)
//        {
//            for (int j = i + 1; j < n - 1; j++)
//            {
//                if (nums[i] >= nums[j]) continue;
//                for (int k = j + 1; k < n; k++)
//                {
//                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
//                }
//            }
//        }
//        return false;
//    }

    // Leetcode Solution #3 Times out
//    public boolean find132pattern(int[] nums)
//    {
//        List<int[]> intervals = new ArrayList<>();
//        int i = 1, s = 0;
//        while (i < nums.length)
//        {
//            if (nums[i] < nums[i - 1]) // starts going downhill
//            {
//                if (s < i - 1)
//                    intervals.add(new int[] {nums[s], nums[i - 1]});
//                s = i;
//            }
//            for (int[] a: intervals)
//                if (nums[i] > a[0] && nums[i] < a[1])
//                    return true;
//            i++;
//        }
//        return false;
//    }

    // From discussion
    // https://leetcode.com/problems/132-pattern/discuss/2015159/JAVA-100-FASTER-CODE

    public boolean find132pattern(int[] nums)
    {
        int second=Integer.MIN_VALUE;
        int index=nums.length; //using nums itself as the stack (bottom on the right end)
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<second) return true;
            else while(index<nums.length && nums[i]>nums[index]) second=nums[index++];
            nums[--index]=nums[i];
        }
        return false;
    }
}
