package n01_data_structures;

import utils01.ListNode;

public class LC0237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
