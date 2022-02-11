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

    public void merge(int[] nums1, int m, int[] nums2, int n) {

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
}
