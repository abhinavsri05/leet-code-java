package n10_array_operations;

public class P0136SingleNumber {
    public int singleNumber(int[] nums) {
        // A XOR A = 0, 0 XOR B = B

        int unique = 0;

        for (int i: nums)
            unique = unique ^ i;

        return unique;

    }
}
