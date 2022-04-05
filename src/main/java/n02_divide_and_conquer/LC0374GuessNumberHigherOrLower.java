package n02_divide_and_conquer;

public class LC0374GuessNumberHigherOrLower
{
    int myNum;
    LC0374GuessNumberHigherOrLower(int k)
    {
        myNum = k;
    }

    int guess(int n)
    {
        if (n == myNum) return 0;
        if (n > myNum) return -1;
        return 1;
    }
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid;
        int guessResult;

        while (start < end)
        {
            mid = start + (end - start) / 2;
            guessResult = guess(mid);
            if (guessResult == 0) return mid;
            if (guessResult == -1)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}
