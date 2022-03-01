package n03_graphs;

public class LC0547NumberOfProvinces {
    private void dfs(int vertex, boolean[] visited, int[][] isConnected)
    {
        if (visited[vertex]) return;
        visited[vertex] = true;
        for (int i = 0; i < isConnected.length; i++)
        {
            if (i != vertex && isConnected[vertex][i] == 1) dfs(i, visited, isConnected);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        boolean[] visited = new boolean[m];
        int cc = 0;

        for(int i = 0; i < m; i++)
        {
            if (!visited[i])
            {
                cc++;
                dfs(i, visited, isConnected);
            }
        }
        return cc;

    }
}
