package n07_recursion_backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0077Combination
{
    private List<List<Integer>> output;
    private int n, k;

    private void backtrack(int start, LinkedList<Integer> combination)
    {
        if (combination.size() == k)
            output.add(new LinkedList<Integer>(combination));

        for (int i = start; i <= n; i++)
        {
            // add new element and explore further
            combination.add(i);
            System.out.println("Start: " + start + ", Added: " + i);
            backtrack(i + 1, combination);
            // remove the last element added so that all iteration of the loop start at the same list.
            System.out.println("Start: " + start + ", Removed: " + combination.getLast());
            combination.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k)
    {
        this.n = n;
        this.k = k;
        this.output = new LinkedList<>();

        backtrack(1, new LinkedList<Integer>());
        return this.output;
    }

//    public static void main(String[] args) {
//        List<List<Integer>> o = combine(4, 2);
//
//        for (List<Integer> l : o)
//        {
//            for (Integer i: l)
//            {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }


//    }
}
