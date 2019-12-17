package com.jq.learning;

import java.util.Stack;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class zhan {
    public static void main(String[] args) {
        zhan.push(1);
        System.out.println(zhan.min());
    }
    static Stack<Integer> minStack =  new Stack<Integer>();
    static Stack<Integer> s =  new Stack<Integer>();
    public static void push(int node) {
        s.push(node);
        if (s.size() == 1){
            minStack.push(node);
        }else if (minStack.peek()>=node){
            minStack.push(node);
        }
    }

    public static void pop() {
        Integer pop = s.pop();
        if (pop.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public static int top() {
        return s.peek();
    }

    public static int min() {
//        if (s.empty()){
//            throw new RuntimeException();
//        }
//        Stack<Integer> stack = new Stack<>();
//        int min = s.peek();
//        while (!s.empty()){
//            Integer pop = s.pop();
//            min = Math.min(pop,min);
//            stack.push(pop);
//        }
//        while (!stack.empty()){
//            s.push(stack.pop());
//        }
//        return min;
        return minStack.peek();
    }
}
