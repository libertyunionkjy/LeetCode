package hot100;
/**
 * 206.反转链表
 */

import datastructure.ListNode;

public class ReverseList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseBetween_iteration(head,left,right);
    }

    /**
     *
     * @param head
     * @return
     * 反转链表，改指针
     */

    public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverseList_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList_iteration(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        return pre;
    }

    /**
     * 反转部分链表：https://leetcode-cn.com/problems/reverse-linked-list-ii/
     */

    ListNode successor;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode newhead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newhead;
    }

    public ListNode reverseBetween_recursion(ListNode head, int m, int n) {
        if (m == 1)
            return reverseN(head, n);
        head.next = reverseBetween_recursion(head.next, m - 1, n - 1);
        return head;
    }


    public ListNode reverseBetween_iteration(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode end = head, successor;
        ListNode pre = dummyNode;
        ListNode start = head;
        for (int i = 0; i < n - 1; i++) {
            if (i < m - 1) {
                start = start.next;
                pre = pre.next;
            }
            end = end.next;
        }
        successor = end.next;
        end.next = null;
        pre.next = end;
        reverseList_iteration(start);
        start.next = successor;
        return dummyNode.next;
    }
}

