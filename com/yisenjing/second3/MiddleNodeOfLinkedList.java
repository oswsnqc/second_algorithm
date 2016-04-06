package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class MiddleNodeOfLinkedList {
    public ListNode findMiddleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
