package com.jq.learning;

import java.util.ArrayList;
import java.util.Stack;

public class 链表转arraylist {
    public static void main(String[] args) {
        ListNode l = null;
        ArrayList<Integer> integers = printListFromTailToHead(l);

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<Integer>();
        }
        Stack<Integer> integerStack = new Stack<>();
        while (listNode!=null){

            integerStack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (!integerStack.empty()){
            integers.add(integerStack.pop());
        }
        return integers;

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}