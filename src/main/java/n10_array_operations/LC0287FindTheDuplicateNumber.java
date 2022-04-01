package n10_array_operations;

public class LC0287FindTheDuplicateNumber {
    // Uses O(n) space
    public int findDuplicate1(int[] nums)
    {
        int n;
        int[] counts  = new int[nums.length];

        for (n = 0; n < nums.length; n++)
        {
            counts[nums[n] - 1]++;
            if (counts[nums[n] - 1] >= 2)
                break;
        }
        return nums[n];
    }

     // Using O(1) space but modifies array
     public int findDuplicate2(int[] nums)
     {
         int n;
         int num = 0;
         for (n = 0; n < nums.length; n++)
         {
             num = Math.abs(nums[n]);
             if (nums[num - 1] < 1)
                 break;
             nums[num - 1] *= -1;
         }

         return num;
     }

     // Using O(1) space and does not modifies array
    


}
