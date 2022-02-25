package n01_data_structures;

import utils.ListNode;

public class LC0082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode node = new ListNode(0, head);  // sentinel head
        ListNode prev = node;

        boolean deleted;
        while (head != null && head.next != null)
        {
            deleted = false;
            while (head != null && head.next != null && head.val == head.next.val)
            {
                head.next = head.next.next;
                deleted = true;
            }
            if (deleted)
            {
                prev.next = head.next;
            }
            else
                prev = head;
            if (head == null) break; else head = head.next;
        }
        return node.next;
    }
}
