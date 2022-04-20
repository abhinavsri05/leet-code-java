package leet_code_contests.weekly.wc288_20220409;

public class LC2232MinimizeResultByAddingParenthesesToExpression
{
    int evaluate(String exp)
    {
        String n1 = exp.split("\\(").length <= 1 ? "1" : exp.split("\\(")[0];
        String n2 = exp.split("\\(")[1].split("\\)")[0].split("\\+")[0];
        String n3 = exp.split("\\(")[1].split("\\)")[0].split("\\+")[1];
        String n4 = exp.split("\\(")[1].split("\\)").length <= 1 ? "1" : exp.split("\\(")[1].split("\\)")[1];
        int num1 = Integer.parseInt(n1.equals("") ? "1" : n1);
        int num4 = Integer.parseInt(n4.equals("") ? "1" : n4);
        int num2 = Integer.parseInt(n2);
        int num3 = Integer.parseInt(n3);
        // System.out.println(exp + " = " + num1 * (num2 + num3) * num4);
        return num1 * (num2 + num3) * num4;
    }
    public String minimizeResult(String expression) {
        StringBuilder res = new StringBuilder(expression);
        String output = expression;
        String[] nums = expression.split("\\+");
        int l1 = nums[0].length();
        int l2 = nums[1].length();
        long bestSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < l1; i++)
        {
            for (int j = 1; j <= l2; j++)
            {
                res.insert(i, '(');
                if (l1 + 2 + j == res.length())
                    res.append(")");
                else
                    res.insert(l1 + 2 + j, ')'); // + 2 to account for + and (
                sum = evaluate(res.toString());
                if (sum < bestSum)
                    output = res.toString();
                bestSum = Math.min(bestSum, sum);
                res.deleteCharAt(l1 + j + 2);
                res.deleteCharAt(i);
            }
        }

        return output;


    }
}
