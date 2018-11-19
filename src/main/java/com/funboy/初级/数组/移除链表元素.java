package com.funboy.初级.数组;

import org.junit.Test;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-16 14:51
 * @Description: 移除链表元素
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class 移除链表元素 {
    @Test
    public void go() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode listNode = removeElements(a, 1);
     //   System.out.println(listNode.val);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
       ListNode temp = new ListNode(-1);
       ListNode returnNode = temp;
       while(null != head){
           if(val == head.val){
               temp.next = head.next;
           }else{
               temp.next = head;
               temp = temp.next;
           }
           head = head.next;
       }

       return returnNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
