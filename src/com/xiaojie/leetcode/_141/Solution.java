package com.xiaojie.leetcode._141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 进阶：
 * 你能否不使用额外空间解决此题？
 *
 * @author xiaojie
 * @date 2018/10/18
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
//        Assertions.assertFalse(hasCycle(n1));
        n5.next = n3;
        Assertions.assertTrue(hasCycle2(n1));
    }

    /**
     * 方法一：使用 HashSet
     * 我们用 HashSet 来保存每个节点的引用，如果遍历到相同的引用那就一定有环
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 方法二：差速跑
     * 题目还要求不使用额外空间的方式解决问题
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;
        while (node2 != null && node2.next != null) {
            if (node1.equals(node2)) {
                return true;
            }
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
