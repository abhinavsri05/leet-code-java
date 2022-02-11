package n10_array_operations;

public class LC0026RemoveDuplicatesFromSortedArray {
//    private void shiftLeft(int[] nums, int startIndex, int steps, int k)
//    {
//        for (int i = startIndex; i < k; i++)
//        {
//            nums[i - steps] = nums[i];
//        }
//    }
//
//    public int removeDuplicates(int[] nums) {
//
//        int k = nums.length;
//        int steps = 0;
//        int i, j;
//
//        for (i = 0; i < k - 1; i++)
//        {
//            steps = 0;
//            for (j = i + 1; j < k; j++)
//            {
//                if (nums[i] == nums[j])
//                    steps ++;
//                else
//                    break;
//            }
//            if (steps != 0)
//            {
//                shiftLeft(nums, j - 1, steps, k);
//                k -= steps;
//            }
//        }
//        return k;
//
//    }

    // Using two pointers

    public int removeDuplicates(int[] nums) {

        int k = nums.length;
        int insertAt = 1;
        int i;

        for (i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] == nums[i + 1])
                k--;
            else
                nums[insertAt++] = nums[i + 1];
        }
        return k;

    }

    // LeetCode Solution

//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }
}
