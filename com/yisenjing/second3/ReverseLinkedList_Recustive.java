package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class ReverseLinkedList_Recustive {

    public ListNode reserve_recursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = reserve_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }
}
