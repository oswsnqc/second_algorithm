package com.yisenjing.second21;

import com.yisenjing.second3.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Yisen on 3/25/16.
 */
public class MergeKSortedLists {


    public ListNode mergeList(List<ListNode> listOfLists) {
        if (listOfLists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.key == o2.key) {
                    return 0;
                }
                return o1.key < o2.key ? -1 : 1;
            }
        });

        for (ListNode node : listOfLists) {
            minHeap.offer(node);
        }

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            cur.next = temp;

            if (temp.next != null) {
                minHeap.offer(temp.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }


}
