package n01_data_structures;

public class P0035SearchInsertPosition {
    public static int searchInsert(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end)
        {
            mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
    }
}
