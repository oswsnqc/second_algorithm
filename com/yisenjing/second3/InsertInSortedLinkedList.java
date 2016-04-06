package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class InsertInSortedLinkedList {

    public ListNode insertLL(ListNode head, int value) {

        ListNode newNode = new  ListNode(value);
        if (head == null || value <= head.key) {
            newNode.next = head;
            return newNode;
        }

        ListNode prev = head;

        while (prev.next != null && prev.next.key < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }


}
