package com.jq.learning;

import java.util.Stack;

public class 用两个栈实现队列 {
    public static void main(String[] args) {

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();

        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return pop;
    }
}
