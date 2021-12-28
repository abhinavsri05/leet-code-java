package n01_data_structures;

public class P0021MergeTwoSortedLists
{
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
//    {
//        ListNode root, merged;
//
//        if (list1 == null)
//            return list2;
//        if (list2 == null)
//            return list1;
//
//        if (list1.val < list2.val)
//        {
//            root = list1;
//            list1 = list1.next;
//        }
//        else
//        {
//            root = list2;
//            list2 = list2.next;
//        }
//
//        merged = root;
//        merged.next = null;
//
//        while (list1 != null && list2 != null)
//        {
//            if (list1.val < list2.val)
//            {
//                merged.next = list1;
//                list1 = list1.next;
//            }
//            else
//            {
//                merged.next = list2;
//                list2 = list2.next;
//            }
//
//            merged = merged.next;
//            merged.next = null;
//        }
//
//        if (list1 == null)
//            merged.next = list2;
//
//        if (list2 == null)
//            merged.next = list1;
//
//        return root;
//    }

    // Made minor modification to remove unnecessary code
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode root = new ListNode(0), merged;

//         if (list1 == null)
//             return list2;
//         if (list2 == null)
//             return list1;

//         if (list1.val < list2.val)
//         {
//             root = list1;
//             list1 = list1.next;
//         }
//         else
//         {
//             root = list2;
//             list2 = list2.next;
//         }

        merged = root;

        while (list1 != null && list2 != null)
        {
            if (list1.val < list2.val)
            {
                merged.next = list1;
                list1 = list1.next;
            }
            else
            {
                merged.next = list2;
                list2 = list2.next;
            }

            merged = merged.next;
//            merged.next = null;
        }

        if (list1 == null)
            merged.next = list2;
        else
            merged.next = list1;

        return root.next;
    }

}
