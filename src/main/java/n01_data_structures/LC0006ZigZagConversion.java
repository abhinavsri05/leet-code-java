package n01_data_structures;

public class LC0006ZigZagConversion
{
    public String convert(String s, int numRows)
    {
        int l = s.length();
        if (l <= 1 || numRows <= 1)
            return s;

        StringBuilder output = new StringBuilder();
        int cyclicity = 2 * numRows - 2;

        for (int c = 0; c < numRows; c++)
        {
            for(int i = 0; i <= l + c; i += cyclicity)
            {
                if (i - c > 0 && i - c < l && c != 0 && i + c - cyclicity != i - c)
                    output.append(s.charAt(i - c));
                if (i + c < l)
                    output.append(s.charAt(i + c));
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        LC0006ZigZagConversion ob = new LC0006ZigZagConversion();
        String ret = ob.convert("RAJSHREE", 3);
        boolean result = ret.equals("ABCED");
        System.out.println(result);
        if (!result)
        {
            System.out.println("Returned Value: " + ret);
        }
    }

}
