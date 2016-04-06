package com.yisenjing.second3;

/**
 * Created by Yisen on 2/26/16.
 */
public class ReOrderLinkedList {

    public ListNode reOrder(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddleNode(head);
        ListNode secondHead = middle.next;
        middle.next = null;
        secondHead = reverse(secondHead);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && secondHead != null) {
            cur.next = head;
            head = head.next;
            cur.next.next = secondHead;
            secondHead = secondHead.next;
            cur = cur.next.next;
        }

        if (head != null) {
            cur.next = head;
        } else {
            cur.next = secondHead;
        }

        return dummy.next;
    }


    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode reverse(ListNode head) {
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
