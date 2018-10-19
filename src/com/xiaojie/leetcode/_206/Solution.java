package com.xiaojie.leetcode._206;

import org.junit.jupiter.api.Test;

/**
 * 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author xiaojie
 * @date 2018/10/15
 */
public class Solution {

    @Test
    void test() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        n4.next = n5;
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        reverseList2(n1);
    }

    /**
     * 019 题里面已经反转过了
     */
    public ListNode reverseList(ListNode head) {
        ListNode head2 = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = head2;
            head2 = head;
            head = next;
        }
        return head2;
    }

    /**
     * 方法二，递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode head2 = reverseList2(next);
        next.next = head;
        return head2;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
