package com.xiaojie.leetcode._234;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author xiaojie
 * @date 2018/10/15
 */
public class Solution {

    @Test
    void test() {
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(5);
//        ListNode n4 = new ListNode(4);
        n4.next = n5;
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;
//        Assertions.assertFalse(isPalindrome(n1));
        Assertions.assertTrue(isPalindrome(n1));
    }

    /**
     * 解法
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        // 这里 node2 以两倍速度往后走，node2 走完以后 node1 就是后半截链表了
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        // 反转链表
        node1 = reverseNode(node1);
        while (node1 != null) {
            // 比较
            if (node1.val == head.val) {
                node1 = node1.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode reverseNode(ListNode node1) {
        ListNode node = null;
        while (node1 != null) {
            ListNode next = node1.next;
            node1.next = node;
            node = node1;
            node1 = next;
        }
        return node;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
