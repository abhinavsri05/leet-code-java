package n10_array_operations;

public class P0238ProductofArrayExceptSelf
{
    // First attempt - used division but division is NOT allowed so incorrect solution.
//    public int[] productExceptSelf(int[] nums)
//    {
//        int prod = 1;
//        int zeroIdx = -1;
//        int i;
//        int[] output = new int[nums.length];
//
//        for (i = 0; i < nums.length; i++)
//        {
//            if (zeroIdx == -1 && nums[i] == 0)
//            {
//                zeroIdx = i;  // First zero encountered.
//                continue;
//            }
//            if (zeroIdx > -1 && nums[i] == 0)
//            {
//                prod = 0;
//                break;
//            }
//            prod *= nums[i];
//        }
//
//        for (i = 0; i < nums.length; i++)
//            if (zeroIdx > -1)
//                if (i == zeroIdx)
//                    output[i] = prod;
//                else
//                    output[i] = 0;
//            else
//                output[i] = prod/nums[i];
//
//        return output;
//
//
//    }

    public int[] productExceptSelf(int[] nums)
    {
        int[] output = new int[nums.length];
        output[0] = 1;
        int i;
        int tempProdSuffix = 1;

        // Get prefix product
        for (i = 1; i < nums.length; i++)
        {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Get suffix product

        for (i = nums.length - 2 ; i >= 0; i--)
        {
            tempProdSuffix = tempProdSuffix * nums[i + 1];
            output[i] = output[i] * tempProdSuffix;
        }

        return output;
    }
}
