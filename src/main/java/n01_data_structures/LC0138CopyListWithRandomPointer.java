package n01_data_structures;

import utils03.Node;

import java.util.HashMap;
import java.util.LinkedList;

public class LC0138CopyListWithRandomPointer {

    // Attempt 1: Uses two HashMap
    public Node copyRandomList1(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        HashMap<Node, LinkedList<Node>> randomAhead = new HashMap<>();
        LinkedList<Node> parents;

        Node prev = new Node(head.val);
        Node ret = prev;

        map.put(head, prev);

        if (head.random == head)
            prev.random = prev;
        else if (head.random != null)
        {
            parents = new LinkedList<>();
            parents.add(prev);
            randomAhead.put(head.random, parents);
        }

        head = head.next;

        while (head != null)
        {
            Node newNode = new Node(head.val);
            map.put(head, newNode);

            if (head.random != null)
            {
                if (map.containsKey(head.random))
                    newNode.random = map.get(head.random);
                else
                {
                    parents = randomAhead.getOrDefault(head.random, new LinkedList<>());
                    parents.add(newNode);
                    randomAhead.put(head.random, parents);
                }
            }

            if (randomAhead.containsKey(head))
                for (Node n: randomAhead.get(head))
                    n.random = newNode;

            prev.next = newNode;
            prev = newNode;
            head = head.next;
        }

        return ret;
    }

    // Attempt 2: Two Recursions (Treat it as a graph)
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        if (map.containsKey(head))
            return map.get(head);

        Node newNode = new Node(head.val);
        map.put(head, newNode);

        newNode.next = copyRandomList2(head.next);
        newNode.random = copyRandomList2(head.random);

        return newNode;
    }

    // Attempt 3
    /*
    Modify attempt 1 - If random does not exists then create node and add to HashMap
    Can be done with one HashMap
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node node = new Node(head.val);
        map.put(head, node);

        if (head.random != null)
        {
            if(map.containsKey(head.random))
                node.random = map.get(head.random);
            else
            {
                Node rdm = new Node(head.random.val);
                map.put(head.random, rdm);
                node.random = rdm;
            }
        }

        Node ret = node;
        Node prev = node;
        head = head.next;

        while (head != null)
        {
            node = map.getOrDefault(head, new Node(head.val));
            map.put(head, node);

            if (head.random != null)
            {
                if(map.containsKey(head.random))
                    node.random = map.get(head.random);
                else
                {
                    Node rdm = new Node(head.random.val);
                    map.put(head.random, rdm);
                    node.random = rdm;
                }
            }
            prev.next = node;
            prev = node;
            head = head.next;
        }

        return ret;
    }

    // Attempt 4: No extra space
    /*
    Add the new node immediately after the original node in the main linked list.
    Assign random
    Restore orig and cloned lists.
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node ptr = head;
        Node node;

        while (ptr != null)
        {
            node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }

        ptr = head;
        Node ret = ptr.next;

        // Assign Random

        while (ptr != null)
        {
            if (ptr.random != null) ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;

        }

        ptr = head;

        // Restore links

        Node origList = ptr;
        Node clonedList = ptr.next;

        while (origList != null)
        {
            origList.next = origList.next.next;
            clonedList.next = (clonedList.next != null ? clonedList.next.next : null);
            origList = origList.next;
            clonedList = clonedList.next;
        }

        return ret;
    }


}
