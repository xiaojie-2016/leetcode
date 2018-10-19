package com.xiaojie.leetcode._021;

import org.junit.jupiter.api.Test;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author xiaojie
 * @date 2018/10/15
 */
public class Solution {
    @Test
    void test() {
        ListNode n8 = new ListNode(8);
        ListNode n7 = new ListNode(7);
        n7.next = n8;
        ListNode n6 = new ListNode(6);
        n6.next = n7;

        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        n4.next = n5;
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        mergeTwoLists(n1, n6);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return node.next;
    }

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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
