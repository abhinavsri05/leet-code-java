public class P0012IntegerToRoman
{
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
    private final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
    public String intToRoman(int num)
    {

        StringBuilder output = new StringBuilder();

        for (int c = 0; num > 0; num = num % values[c], c++)
        {
            output.append(symbol[c].repeat(num / values[c]));
        }
        return output.toString();

    }

    public static void main(String[] args) {
        P0012IntegerToRoman ob = new P0012IntegerToRoman();
        String ret = ob.intToRoman(58);
        boolean result = ret.equals("LVIII");
        System.out.println(result + " " + ret);
        if (!result)
        {
            System.out.println("Returned Value: " + ret);
        }
    }
}
