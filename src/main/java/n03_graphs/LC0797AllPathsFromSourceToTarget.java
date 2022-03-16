package n03_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0797AllPathsFromSourceToTarget {
    // Attempt 1: Using Adj List
    // https://stackoverflow.com/questions/22553843/dynamic-generation-of-2d-array-having-different-column-lengths/22555345

    private int target;
    private List<List<Integer>> output;

    private ArrayList<ArrayList<Integer>> convertToAdjList(int[][] graph)
    {
        int i, j;
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (i = 0; i < n; i++)
        {
            ArrayList<Integer> adj = new ArrayList<>();
            for (j = 0; j < graph[i].length; j++)
            {
                if (graph[i][j] >= 0 && graph[i][j] < n)
                    adj.add(graph[i][j]);
            }
            adjList.add(adj);
        }

        return adjList;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adjList, int node, LinkedList<Integer> path)
    {
        if (adjList.get(node).size() == 0)
            return;

        for (Integer n: adjList.get(node))
        {
            path.add(n);
            if (n == target)
                output.add(new LinkedList<Integer>(path));
            else
                dfs(adjList, n, path);
            path.removeLast();
        }
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        System.out.println(graph.length);
        System.out.println(graph[0].length);
        System.out.println(graph[1].length);
        target = graph.length - 1;
        output = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adjList = convertToAdjList(graph);
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);

        dfs(adjList, 0, path);

        return output;

    }

    // Attempt 2
    // Note a 2D array in Java does not need to be rectangle
    private void dfs(int[][] graph, int node, LinkedList<Integer> path)
    {
//         if (graph[node].length == 0)
//             return;

        for (int n: graph[node])
        {
            path.add(n);
            if (n == target)
                output.add(new LinkedList<Integer>(path));
            else
                dfs(graph, n, path);
            path.removeLast();
        }
    }


    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        target = graph.length - 1;
        output = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);

        dfs(graph, 0, path);

        return output;

    }
}
