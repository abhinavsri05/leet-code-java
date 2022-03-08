package n01_data_structures;

import utils01.ListNode;

public class LC0021MergeTwoSortedLists
{
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

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
//    {
//        if (list1 == null) return list2;
//        if (list2 == null) return list1;
//
//        if (list1.val < list2.val)
//        {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        }
//        else
//        {
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
//
//    }

}
