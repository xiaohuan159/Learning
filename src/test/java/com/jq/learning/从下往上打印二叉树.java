package com.jq.learning;

import java.util.ArrayList;
import java.util.Stack;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从下往上打印二叉树 {
    public static void main(String[] args) {
        Stack<Integer> result = new Stack<>();
        result.push(null);
        System.out.println(result.empty());
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Stack<TreeNode> result = new Stack<>();
        ArrayList<TreeNode> first = new ArrayList<>();
        first.add(root);
        result.push(root);
        ArrayList<Integer> re = new ArrayList<>();
        Stack<TreeNode> hehe = hehe(first, result);
        while (!hehe.empty()){
            re.add(hehe.pop().val);
        }
        return re;
    }
    public static Stack<TreeNode> hehe(ArrayList<TreeNode> hehe,Stack<TreeNode> result){
        ArrayList<TreeNode> temp = new ArrayList<>();

        for (TreeNode pop : hehe) {
            if (pop.right!=null){

                temp.add(pop.right);
                result.push(pop.right);
            }
            if (pop.left !=null){
                temp.add(pop.left);
                result.push(pop.left);
            }
        }
        if (temp.size() == 0){
            return result;
        }else {
            return hehe(temp,result);
        }
    }
}
