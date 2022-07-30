package n01_data_structures;

import utils01.ListNode;

public class LC0086PartitionList {

    /*
    This does not work and is complicated

    We do not need to rearrange the node in list. Just move nodes to two lists and you iterate. The first list contains elements < x and the other contains elements >= x. Finally, concatenat the two lists. DO NOT OVERCOMPLICATE!!

    public ListNode partition(ListNode head, int x)
    {
        ListNode node = new ListNode();
        node.next = head;
        ListNode ptr1, ptr2;
        ptr1 = node;
        ptr2 = node;

        // ptr1 will point to the first node from start that is >= x
        // ptr2 will point to the first node after ptr1 that is < x
        while (true)
        {
            while (ptr1.next.val < x)
            {
                ptr1 = ptr1.next;
            }

            while (ptr2.next.val >= x)
            {
                ptr2 = ptr2.next;
            }

            if (ptr1.next == null || ptr2.next == null) break;

            ListNode temp1 = ptr1.next;
            ListNode temp2 = ptr2.next;
            temp1.next = ptr2.next.next;
            temp2.next = ptr1.next.next;
            ptr1.next = temp2;
            ptr2.next = temp1;
        }

        return node.next;
    }
   */
    public ListNode partition(ListNode head, int x)
    {
        ListNode lt = new ListNode();
        ListNode gte = new ListNode();

        ListNode ltTemp = lt;
        ListNode gteTemp = gte;

        while (head != null)
        {
            if (head.val < x)
            {
                ltTemp.next = head;
                ltTemp = ltTemp.next;
            }
            else
            {
                gteTemp.next = head;
                gteTemp = gteTemp.next;
            }

            head = head.next;
        }

        gteTemp.next = null; // Needed to prevent cycle.

        ltTemp.next = gte.next;

        return lt.next;
    }
}
