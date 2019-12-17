package com.jq.learning;

import java.util.ArrayList;

public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = PrintFromTopToBottom(null);

    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        /*解1
        if (root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> first = new ArrayList<>();
        first.add(root);
        result.add(root.val);
        ArrayList<Integer> hehe = hehe(first, result);
        return hehe;*/


        //解2
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0){
            TreeNode remove = queue.remove(0);
            if (remove.left!=null){
                queue.add(remove.left);
            }
            if (remove.right!=null){
                queue.add(remove.right);
            }
            result.add(remove.val);
        }
        return result;
    }

    private static ArrayList<Integer> hehe(ArrayList<TreeNode> hehe, ArrayList<Integer> result) {
        ArrayList<TreeNode> temp = new ArrayList<>();

        for (TreeNode pop : hehe) {
            if (pop.left!=null){

                temp.add(pop.left);
                result.add(pop.left.val);
            }
            if (pop.right !=null){
                temp.add(pop.right);
                result.add(pop.right.val);
            }
        }
        if (temp.size() == 0){
            return result;
        }else {
            return hehe(temp,result);
        }
    }
}
