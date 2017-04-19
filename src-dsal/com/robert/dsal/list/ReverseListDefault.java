package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;

public class ReverseListDefault implements ReverseList{

    public LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode headInverse = null;
        while (head != null) {
            LinkedListNode tmp = head.next;

            head.next = headInverse;
            headInverse = head;

            head = tmp;
        }

        return headInverse;
    }
}
