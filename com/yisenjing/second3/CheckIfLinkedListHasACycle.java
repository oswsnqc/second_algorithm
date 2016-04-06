package com.yisenjing.second3;

/**
 * Created by Yisen on 2/23/16.
 */
public class CheckIfLinkedListHasACycle {

    public boolean checkcycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
