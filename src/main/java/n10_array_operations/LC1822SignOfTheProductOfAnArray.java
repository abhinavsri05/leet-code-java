package n10_array_operations;

public class LC1822SignOfTheProductOfAnArray
{
//    public int arraySign(int[] nums) {
//        int sign = 1;
//        for (int i: nums)
//        {
//            sign = sign * (i > 0 ? 1 : (i < 0 ? -1 : 0));
//        }
//
//        return sign;
//
//    }

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int i: nums)
        {
            if (i == 0) return 0;
            if (i < 0) sign = -1 * sign;
        }

        return sign;

    }
}
