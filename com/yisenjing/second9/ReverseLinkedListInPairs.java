package com.yisenjing.second9;

/**
 * Created by Yisen on 3/6/16.
 */
import com.yisenjing.second3.ListNode;
public class ReverseLinkedListInPairs {

    public ListNode reversePair(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;

            next.next = cur.next;
            cur.next = next;
            cur = next.next;
        }
        return dummy.next;
    }
}
