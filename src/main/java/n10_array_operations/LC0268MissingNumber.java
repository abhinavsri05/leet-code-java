package n10_array_operations;

public class LC0268MissingNumber {
    public int missingNumber(int[] nums)
    {
        // Sum must match

//         int sum = 0;

//         for (int n: nums)
//         {
//             sum += n;
//         }

//         return (nums.length + 1) * nums.length / 2 - sum;

        // Bit Manipulation

        int missing = nums.length;

        for (int i = 0; i < nums.length; i++)
        {
            missing = missing ^ i ^ nums[i];
        }

        return missing;
    }
}
