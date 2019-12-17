package com.jq.learning;
/*
输入一个复杂链表
（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode randomListNode0 = new RandomListNode(0);
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        randomListNode0.next = randomListNode1;
        randomListNode1.next = randomListNode2;
        randomListNode2.random = randomListNode0;
        RandomListNode clone = Clone(randomListNode0);
        System.out.println(clone.label);
        System.out.println(clone.next.label);
        System.out.println(clone.next.next.label);
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode curNode= pHead;
        while (curNode!=null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            RandomListNode next = curNode.next;
            curNode.next = cloneNode;
            cloneNode.next = next;
            curNode = next;
        }
        curNode = pHead;
        while (curNode!=null){
            curNode.next.random = curNode.random == null? null:curNode.random.next;
            curNode = curNode.next.next;
        }
        RandomListNode reHead = pHead.next;
        RandomListNode temp = pHead;
        while (temp!=null){
            RandomListNode temp1 = pHead.next;
            temp.next = temp1.next;
            reHead.next = temp1.next == null? null : temp1.next.next;
            temp = reHead.next;
        }
        return reHead;


//        RandomListNode currentNode = pHead;
//        RandomListNode pCloneHead = pHead.next;
//        while(currentNode != null) {
//            RandomListNode cloneNode = currentNode.next;
//            currentNode.next = cloneNode.next;
//            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
//            currentNode = currentNode.next;
//        }
//
//        return pCloneHead;

    }



    static class  RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
