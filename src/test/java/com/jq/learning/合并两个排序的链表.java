package com.jq.learning;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {

    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        ListNode temp = head;
        while (list2 != null && list1 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            } else {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return head;
    }

    public static ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            }

        }


        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        ListNode temp = head;
        while (list2 != null && list1 != null) {

            if (list1.val > list2.val) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            } else {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            while (list2 != null) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        } else {
            while (list1 != null) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }
        return head;
    }
}
