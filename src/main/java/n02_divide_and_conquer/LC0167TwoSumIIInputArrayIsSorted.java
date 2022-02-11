package n02_divide_and_conquer;

public class LC0167TwoSumIIInputArrayIsSorted {
//    private static int binarySearch(int[] nums, int start, int end, int srch)
//    {
//        int mid;
//
//        while (start <= end)
//        {
//            mid = start + (end - start) / 2;
//
//            if (nums[mid] == srch)
//            {
//                return mid;
//            }
//
//            if (nums[mid] > srch)
//            {
//                end = mid - 1;
//            }
//            else
//            {
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public static int[] twoSum(int[] numbers, int target)
//    {
//        int[] result = new int[2];
//        int ret;
//
//        for (int i = 0; i < numbers.length; i++)
//        {
//
//            if (target - numbers[i] >= numbers[i])
//                ret = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
//            else
//                ret = binarySearch(numbers, 0, i - 1, target - numbers[i]);
//            System.out.println(ret);
//            if (ret != -1)
//            {
//                result[0] = i + 1;
//                result[1] = ret + 1;
//                break;
//            }
//        }
//        return result;
//    }
    public static int[] twoSum(int[] numbers, int target)
    {
        int start = 0;
        int end = numbers.length - 1;
        int sum;

            while (start <= end)
        {
            sum = numbers[start] + numbers[end]; // this can overflow so change it to long
            if (sum == target)
                return new int[]{start + 1, end + 1};

            if (sum < target)
                start++;
            else
                end--;
        }

            return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] inpt = {0, 0, 3, 4};
        int target = 0;
        int[] rslt = twoSum(inpt, target);

        System.out.println(rslt[0] + ", " + rslt[1]);
    }
}
