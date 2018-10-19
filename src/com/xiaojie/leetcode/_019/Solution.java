package com.xiaojie.leetcode._019;

import org.junit.jupiter.api.Test;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5> 1>>2>3>n, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author xiaojie
 * @date 2018/10/12
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
        removeNthFromEnd2(n1, 2);
    }

    /**
     * 方法一：
     * 思路是先反转链表，然后反转第二次的时候把第 n 个节点删除
     * 但是这样的做法走了两遍扫描
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        head = reverseListNode(head);
        ListNode head2 = null;
        while (head != null) {
            n -= 1;
            if (n != 0) {
                ListNode node = new ListNode(head.val);
                node.next = head2;
                head2 = node;
            }
            head = head.next;
        }
        return head2;
    }

    /**
     * 翻转链表
     */
    private ListNode reverseListNode(ListNode head) {
        ListNode head2 = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = head2;
            head2 = node;
            head = head.next;
        }
        return head2;
    }

    /**
     * 方法二：
     * 使用双指针，第一个指针指向头，第二个指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        ListNode nodeHead = head;
        ListNode nodeN = head;
        while (n-- > 0) {
            nodeN = nodeN.next;
        }
        if (nodeN.next != null) {
            while (nodeN.next != null){
                nodeHead = nodeHead.next;
                nodeN = nodeN.next;
            }
            nodeHead.next = nodeHead.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
