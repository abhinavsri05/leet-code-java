package n01_data_structures;

import utils01.ListNode;

import java.util.HashSet;

public class LC0160IntersectionOfTwoLinkedLists
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        HashSet<ListNode> firstList = new HashSet<>();
        while (headA != null)
        {
            firstList.add(headA);
            headA = headA.next;
        }

        while (headB != null)
        {
            if (firstList.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}
