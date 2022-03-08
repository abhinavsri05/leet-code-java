package n01_data_structures;

import utils01.ListNode;

public class LC0024SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode root = head.next;

        ListNode temp;
        ListNode prev = new ListNode();

        while (head != null && head.next != null)
        {
            prev.next = head.next;
            temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = temp;

        }

        return root;

    }
}
