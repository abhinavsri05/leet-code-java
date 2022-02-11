package n01_data_structures;

public class P0206ReverseLinkedList {
//    public class ListNode
//    {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }

    public ListNode reverseList(ListNode head)
    {
        // Following two lines are not needed
//        if (head == null || head.next == null)
//            return head;

        ListNode prev = null, next;

        while (head != null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }
}
