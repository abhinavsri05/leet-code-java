package n03_graphs;

public class LC0323NumberOfConnectedComponentsInAnUndirectedGraph {
    private void dfs(int vertex, boolean[] visited, int[][] edges)
    {
        if (visited[vertex]) return;
        visited[vertex] = true;
        for (int i = 0; i < edges.length; i++)
        {
            if (edges[i][0] == vertex)
                dfs(edges[i][1], visited, edges);

            else if (edges[i][1] == vertex)
                dfs(edges[i][0], visited, edges);
        }
    }

    public int countComponents(int n, int[][] edges)
    {
        boolean[] visited = new boolean[n];
        int cc = 0;

        for(int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                cc++;
                dfs(i, visited, edges);
            }
        }
        return cc;


    }
}
