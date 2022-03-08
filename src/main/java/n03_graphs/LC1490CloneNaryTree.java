package n03_graphs;

import utils02.Node;

import java.util.HashMap;

public class LC1490CloneNaryTree {
    public Node cloneTree(Node root) {
        if (root == null) return null;
        Node newNode = new Node(root.val);  // children is initialized in the constructor

        for (Node n: root.children)
            newNode.children.add(cloneTree(n));

        return newNode;
    }

    // Below is using LC0133 code (works)
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneTree2(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) return visited.get(node);

        Node copyNode = new Node(node.val);

        visited.put(node, copyNode);
        for (Node n: node.children)
        {
            copyNode.children.add(cloneTree2(n));
        }

        return copyNode;

    }

}
