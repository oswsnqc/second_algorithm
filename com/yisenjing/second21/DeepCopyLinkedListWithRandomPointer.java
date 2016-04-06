package com.yisenjing.second21;

/**
 * Created by Yisen on 3/24/16.
 */
public class DeepCopyLinkedListWithRandomPointer {

    public RandomListNode copy(RandomListNode head) {


        if (head == null) {
            return null;
        }

        RandomListNode cur = head;

        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;

        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = cur.next;

        RandomListNode newCur = dummy;

        while (cur != null) {
            newCur.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            newCur = newCur.next;

        }
        return dummy.next;

    }

}
