package n01_data_structures;

import utils01.ListNode;

public class LC0083RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode iter = head;

        while (iter != null)
        {
            if (iter.next != null && iter.val == iter.next.val)
                iter.next = iter.next.next;
            else  // else condition is needed to handle scenario like 1, 1, 1
                iter = iter.next;
        }

        return head;

    }
}
