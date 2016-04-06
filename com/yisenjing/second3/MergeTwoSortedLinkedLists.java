package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class MergeTwoSortedLinkedLists {

    public ListNode mergeLL(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.key <= two.key) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

}
