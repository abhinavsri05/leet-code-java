package n03_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1202SmallestStringWithSwaps
{
    private ArrayList<Integer>[] buildAdjList(List<List<Integer>> pairs, int n)
    {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        int i;
        for (i = 0; i < n; i++)
        {
            adjList[i] = new ArrayList<Integer>();
        }

        for (List<Integer> p: pairs)
        {
            adjList[p.get(0)].add(p.get(1));
            adjList[p.get(1)].add(p.get(0));
        }

        return adjList;
    }

    private void explore(String s, ArrayList<Integer>[] adjList, boolean[] visited, int node, ArrayList<Character> c, ArrayList<Integer> id)
    {
        if (visited[node]) return;
        visited[node] = true;
        c.add(s.charAt(node));
        id.add(node);
        for (Integer n: adjList[node])
        {
            explore(s, adjList, visited, n, c, id);
        }
    }

    private void getConnectedComponents(String s, ArrayList<Integer>[] adjList, int n, ArrayList<ArrayList<Character>> ch, ArrayList<ArrayList<Integer>> idx)
    {
        boolean[] visited = new boolean[n];
        int i;
        ArrayList<Character> c;
        ArrayList<Integer> id;

        for (i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                c = new ArrayList<>();
                id = new ArrayList<>();
                explore(s, adjList, visited, i, c, id);
                ch.add(c);
                idx.add(id);
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs)
    {
        int n = s.length();
        ArrayList<Integer>[] adjList = buildAdjList(pairs, n);
        ArrayList<ArrayList<Character>> ch = new ArrayList<>();
        ArrayList<ArrayList<Integer>> idx = new ArrayList<>();
        getConnectedComponents(s, adjList, n, ch, idx);

        int cc = ch.size();
        char[] ans = new char[n];

        for (int i = 0; i < cc; i++)
        {
            ArrayList<Character> c = ch.get(i);
            ArrayList<Integer> id = idx.get(i);
            Collections.sort(c);
            Collections.sort(id);

//             System.out.println(c.toString());
//             System.out.println(id.toString());

            for (int j = 0; j < c.size(); j++)
            {
                ans[id.get(j)] = c.get(j);
            }
        }

        return new String(ans);
    }
}
