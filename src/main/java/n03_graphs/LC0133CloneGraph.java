package n03_graphs;

import utils01.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LC0133CloneGraph {

    // Using BFS
    private Node bfs(Node node, HashMap<Integer, Node> map, LinkedList<Node> queue, HashSet<Integer> explored)
    {
        queue.add(node);
        Node oldNode;
        Node newNode;
        boolean first = true;
        Node ret = new Node();

        while (!queue.isEmpty())
        {
            oldNode = queue.remove();
            if(explored.contains(oldNode.val)) continue;
            // System.out.println("\n\nRead and explored: " + oldNode.val);
            explored.add(oldNode.val);
            if (map.containsKey(oldNode.val))
            {
                // System.out.println("Getting Node: " + oldNode.val);
                newNode = map.get(oldNode.val);
            }
            else
            {
                // System.out.println("Creating Node: " + oldNode.val);
                newNode = new Node(oldNode.val, new ArrayList<Node>());
                map.put(oldNode.val, newNode);
            }

            if (first)
            {
                first = false;
                ret = newNode;
            }

            for (Node n: oldNode.neighbors)
            {
                // System.out.println("Neighbor " + n.val + " of " + oldNode.val);
                Node newNeighbor;
                if (!map.containsKey(n.val))
                {
                    // System.out.println("Creating child node: " + n.val);
                    newNeighbor = new Node(n.val, new ArrayList<Node>());
                    map.put(n.val, newNeighbor);
                }
                else
                {
                    // System.out.println("Getting child node: " + n.val);
                    newNeighbor = map.get(n.val);
                }
                // System.out.println("Add neighbor " + newNeighbor.val + " to " + newNode.val);
                newNode.neighbors.add(newNeighbor);
                if (!explored.contains(n.val))
                {
                    // System.out.println("Unexplored: " + n.val + ", add to queue");
                    queue.add(n);
                }

            }
        }
        return ret;
    }
    public Node cloneGraph2(Node node)
    {
        if (node == null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Integer> explored = new HashSet<>();
        return bfs(node, map, queue, explored);
    }

    // Using DFS

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) return visited.get(node);

        Node copyNode = new Node(node.val, new ArrayList<Node>());

        visited.put(node, copyNode);
        for (Node n: node.neighbors)
        {
            copyNode.neighbors.add(cloneGraph(n));
        }

        return copyNode;

    }
}
