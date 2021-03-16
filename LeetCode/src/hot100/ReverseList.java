package hot100;
/**
 * 206.反转链表
 */

import datastructure.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while(p.next != null){
            ListNode tmp =p.next;
            p.next = tmp.next;
            dummy.next = tmp;
            tmp.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
