package com.funboy.中级.链表;

/**
 * @ClassName 两数相加
 * @Description 给出两个  非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照  逆序  的方式存储的，并且它们的每个节点只能存储  一位  数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0  开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author 王帆
 * @Date 2020/10/20 11:57
 * @Version 1.0
 */
public class 两数相加 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        ListNode pre = new ListNode(0);
        ListNode current = new ListNode();
        pre.next = current;
        do {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
            num = sum / 10;
            sum = sum % 10;
            current.val = sum;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
            if (l1 != null || l2 != null || num != 0) {
                current.next = new ListNode(0);
                current = current.next;
            }

        } while (l1 != null || l2 != null || num != 0);

        return pre.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        ListNode x = new 两数相加().addTwoNumbers(l1, l2);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}

