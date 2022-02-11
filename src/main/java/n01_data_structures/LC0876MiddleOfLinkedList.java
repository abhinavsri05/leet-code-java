package n01_data_structures;

public class LC0876MiddleOfLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode next1x = head;
        ListNode next2x = head;

        // next2x will navigate the list twice as fast as first one.

        while (next2x != null && next2x.next != null)
        {
            next1x = next1x.next;
            next2x = next2x.next.next;
        }

        return next1x;
    }
}
