package n03_graphs;

import java.util.Collections;
import java.util.LinkedList;

public class LC1584MinCostToConnectAllPoints
{
    public int minCostConnectPoints(int[][] points)
    {
        LinkedList<int[]> graph = new LinkedList<>();
        int n = points.length;
        int i, j;

        for (i = 0; i < n - 1; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                graph.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});

            }
        }

        Collections.sort(graph, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int c = n;
        int sum = 0;

        for (int[] v: graph)
        {
            uf.union(v[0], v[1]);
            if (c != uf.count())
                sum += v[2];
            c = uf.count();
        }

        return sum;
    }
}

class UnionFind  // also called Disjoint set
{
    private final int[] id;
    private final int[] size;
    private int countComponents;

    public UnionFind(int N)
    {
        countComponents = N;
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int count()
    {
        return countComponents;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    private int root(int p)
    {
        while (id[p] != p)
            p = id[p];
        return p;
    }

    private int find(int p)
    {
        int i = root(p);
        int j;
        // Two pass Path Compression
        while (id[p] != i)
        {
            j = id[p];
            id[p] = i;
            p = j;
        }
        return i;
    }

    public void union(int p, int q)
    {
        p = find(p);
        q = find(q);

        if (p != q)
        {
            if (size[p] >= size[q])
            {
                id[q] = p;
                size[p] += size[q];
            }
            else {
                id[p] = q;
                size[q] += size[p];
            }
            countComponents--;
        }
    }

    public int components()
    {
        return countComponents;
    }
}
