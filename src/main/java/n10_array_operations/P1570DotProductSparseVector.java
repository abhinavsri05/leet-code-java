package n10_array_operations;

import java.util.ArrayList;
import java.util.List;

public class P1570DotProductSparseVector
{
    private List<int[]> nums;

    P1570DotProductSparseVector(int[] nums)
    {
        this.nums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
                this.nums.add(new int[]{i, nums[i]});
        }
    }

    public List<int[]> getNums()
    {
        return this.nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(P1570DotProductSparseVector vec)
    {
        List<int[]> vec2 = vec.getNums();
        int i = 0, j = 0;
        int s1 = this.nums.size();
        int s2 = vec2.size();
        int s = 0;

        if (s1 == 0 || s2 == 0)
            return 0;

        while ( i < s1 && j < s2)
        {
            if (this.nums.get(i)[0] == vec2.get(j)[0])
                s = s + this.nums.get(i++)[1] * vec2.get(j++)[1];
            else
            {
                if (this.nums.get(i)[0] > vec2.get(j)[0])
                    j++;
                else
                    i++;
            }
        }
        return s;
    }
}



