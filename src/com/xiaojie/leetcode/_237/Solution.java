package com.xiaojie.leetcode._237;

import org.junit.jupiter.api.Test;

/**
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 4 -> 5 -> 1 -> 9
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    /**
     * java 是最牛皮的语言
     * 因为不用管内存回收，所以直接赋值就 OK 了
     * 百度上一群拷贝狗，全是一个答案，我就不信那么多看见这个题的都是 C 程序员
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
