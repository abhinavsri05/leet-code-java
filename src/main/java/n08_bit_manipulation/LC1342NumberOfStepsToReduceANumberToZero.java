package n08_bit_manipulation;

public class LC1342NumberOfStepsToReduceANumberToZero
{
    public int numberOfSteps(int num)
    {
        int steps = 0;

        while (num != 0)
        {
            if ((num & 1) == 0)
                num >>= 1; // divide by 2
            else
                num--;
            steps++;
        }
        return steps;
    }
}
