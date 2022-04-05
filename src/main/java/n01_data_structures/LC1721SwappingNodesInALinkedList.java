package n01_data_structures;

import utils01.ListNode;

public class LC1721SwappingNodesInALinkedList
{
    public ListNode swapNodes(ListNode head, int k)
    {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = null;
        int temp;
        int count = 0;

        while (fast != null)
        {
            count++;
            if (count == k) first = fast;
            if (count > k)
            {
                slow = slow.next;
            }
            fast = fast.next;
        }

        temp = first.val;
        first.val = slow.val;
        slow.val = temp;

        return head;
    }
}
