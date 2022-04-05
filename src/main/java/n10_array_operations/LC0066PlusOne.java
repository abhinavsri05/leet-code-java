package n10_array_operations;

public class LC0066PlusOne
{
    public int[] plusOne(int[] digits)
    {
        int n = digits.length;
        int[] sumArray = new int[n];
        int carry = 1;;
        int sum;

        for (int i = n - 1; i >= 0; i--)
        {
            sum = digits[i] + carry;
            sumArray[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 1)
        {
            sumArray = new int[n + 1];
            sumArray[0] = 1;
        }
        return sumArray;
    }
}
