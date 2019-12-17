package com.jq.learning.八皇后;

import java.util.Stack;

public class EightQueen {
    public static void main(String[] args) {

    }

    public static void caculate(int row){
        int count =0;
        Stack<Node> stack = new Stack<>();
        for (int col = 0; col < 8; col++) {

            if (stack.size()==0){
                stack.push(new Node(row,col));
                caculate(++row);
            }else {
                if (isThisNodeOk(stack,row,col)){
                    stack.push(new Node(row,col));
                    if (row==6){
                        ++count;
                        print(stack);
                        stack.pop();

                    }else {
                        caculate(++row);
                    }
                }else {
                   if (col==7){
                       stack.pop();

                   }
                }
            }

        }
    }

    private static void print(Stack<Node> stack) {
        for (Node node : stack) {
            System.out.print(node.toString());
        }
        System.out.println();
    }

    private static boolean isThisNodeOk(Stack<Node> stack, int row, int col) {
        for (Node node : stack) {
            if (node.getCol()==col || (row-node.getRow())==(col-node.getCol())){
                return false;
            }
        }
        return true;
    }
}
