package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
