package n10_array_operations;

public class LC0088MergeSortedArray {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int arr1Max = m - 1;
//        int arr2Max = n - 1;
//
//        for (int i = m + n - 1; i >= 0; i--)
//        {
//            if (arr2Max < 0)  // if we have scanned all the elements of array 2 then the array has been merged. We can just break.
//            {
//                nums1[i] = nums1[arr1Max];
//                arr1Max--;
//            }
//            else if (arr1Max < 0)  // This and next condition can be combined.
//            {
//                nums1[i] = nums2[arr2Max];
//                arr2Max--;
//            }
//            else if (nums1[arr1Max] > nums2[arr2Max])
//            {
//                nums1[i] = nums1[arr1Max];
//                arr1Max--;
//            }
//            else
//            {
//                nums1[i] = nums2[arr2Max];
//                arr2Max--;
//            }
//        }
//
//    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int arr1Max = m - 1;
        int arr2Max = n - 1;

        for (int i = m + n - 1; i >= 0; i--)
        {
            if (arr2Max < 0)
                break;   // elements of first array are already there.

            if (arr1Max >= 0 && nums1[arr1Max] > nums2[arr2Max])
            {
                nums1[i] = nums1[arr1Max];
                arr1Max--;
            }
            else
            {
                nums1[i] = nums2[arr2Max];
                arr2Max--;
            }
        }

    }
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        for (; i >= 0 && p1 >= 0 && p2 >= 0; i--)
        {
            if (nums1[p1] > nums2[p2])
                nums1[i] = nums1[p1--];
            else
                nums1[i] = nums2[p2--];
        }

        // Following two lines are not needed as the values are already in correct place
        // while (p1 >= 0)
        //     nums1[i--] = nums1[p1--];
        while (p2 >= 0)
            nums1[i--] = nums2[p2--];
    }
}
