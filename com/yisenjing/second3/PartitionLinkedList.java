package com.yisenjing.second3;

/**
 * Created by Yisen on 2/26/16.
 */
public class PartitionLinkedList {

    public ListNode partition(ListNode head, int target) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode curSmall = small;
        ListNode curLarge = large;

        while (head != null) {
            if (head.key < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        curLarge.next = null;
        return small.next;
    }

}
