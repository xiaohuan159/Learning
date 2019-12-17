package com.jq.learning;

import java.util.Stack;

public class 链表中倒数第k个节点 {
    public static void main(String[] args) {

    }
    public static ListNode FindKthToTail1(ListNode head,int k) {
        ListNode x = head,y = head;
        int i = 0;
        for (; x!=null; i++) {
            if (i>=k){
                y = y.next;
            }
            x = x.next;
        }
        if (i<k){
            return null;
        }else {
            return y;
        }

    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> listNodes = new Stack<>();
        int leng = 0;
        while (head!=null){
            listNodes.push(head);
            head = head.next;
            ++leng;
        }
        if (leng<k || k == 0){
            return null;
        }

        for (int i = 0; i < k - 1; i++) {
            listNodes.pop();
        }
        return listNodes.pop();
    }

}
