package n01_data_structures;

import utils.ListNode;

public class LC0203RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode dummyHead = new ListNode(0, head);
        ListNode iter = dummyHead;

        while (iter != null && iter.next != null)
        {
            if (iter.next.val == val)
                iter.next = iter.next.next;
            else  // Move to next only if next is not val
                iter = iter.next;
        }

        return dummyHead.next;
    }
}
