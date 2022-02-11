package n11_mathematical_operations;

public class LC0029DivideTwoNumbers {
    // Time limit exceeded
//    public int divide(int dividend, int divisor) {
//
//        boolean negative = (dividend < 0) ^ (divisor < 0);
//        long newDividend = Math.abs((long)dividend);
//        long newDivisor = Math.abs((long)divisor);
//        long quotient = 0;
//        long val = 0;
//        // System.out.println(newDividend);
//        while(val + newDivisor <= newDividend)
//        {
//            quotient++;
//            val += newDivisor;
//        }
//        // System.out.println(negative);
//        quotient = (negative ? -1 * quotient : quotient);
//
//        // System.out.println(quotient);
//        // System.out.println(Integer.MAX_VALUE);
//
//        if (quotient >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if (quotient <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
//        return (int) quotient;
//
//    }

    // Does not satisfy the requirements

//    public int divide(int dividend, int divisor) {
//
//        boolean negative = (dividend < 0) ^ (divisor < 0);
//
//        // Note that the env only supports 32-bit numbers so long not allowed
//
//        long newDividend = Math.abs((long)dividend);  // can cause overflow if all are 32-bit
//        long newDivisor = Math.abs((long)divisor);
//        long temp = 0;
//        long quotient = 0;
//
//        for (int i = 31; i >= 0; i--)
//        {
//            // System.out.println("(divisor << i): " + (newDivisor << i));
//            if ((newDivisor << i) > 0 && (temp + (newDivisor << i)) <= newDividend)
//            {
//                temp += (newDivisor << i);
//                quotient |= (1L << i);
//            }
//        }
//        // System.out.println("Negative: "  + negative);
//        quotient = (negative ? -1 * quotient : quotient); // Note this is multiplication.
//
//        // System.out.println("Q:" + quotient);
//        // System.out.println(Integer.MAX_VALUE);
//
//        if (quotient >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if (quotient <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
//        return (int) quotient;
//
//    }



}
