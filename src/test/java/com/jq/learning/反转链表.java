package com.jq.learning;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = ReverseList(listNode1);
        System.out.println(listNode);
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(head.val);
        res.next = null;

        while (head.next != null) {


            head = head.next;

            ListNode temp = new ListNode(head.val);
            temp.next = res;
            res = temp;
        }
        return res;
    }

    public static ListNode ReverseList1(ListNode head) {
        if (head == null){

            return null;
        }
        ListNode reversedHead = null;
        ListNode current = head;
        ListNode tmp = null;
        ListNode pre = null;
        while (current != null) {
            tmp = current.next;
            current.next = pre;
            if (tmp == null){

                reversedHead = current;
            }
            pre = current;
            current = tmp;

        }
        return reversedHead;
    }

//    public class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
}
