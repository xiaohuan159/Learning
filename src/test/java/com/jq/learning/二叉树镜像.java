package com.jq.learning;

/*
操作给定的二叉树，将其变换为源二叉树的镜像。
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
public class 二叉树镜像 {
    public static void main(String[] args) {

    }

    public void Mirror1(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null){
            Mirror1(root.left);
        }
        if (root.right!=null){
            Mirror1(root.right);
        }
    }

    public void Mirror(TreeNode root) {
        TreeNode mirrorNode = new TreeNode(root.val);
        turn(root, mirrorNode);
        root = mirrorNode;
    }

    public void turn(TreeNode root, TreeNode target) {
        if (root.left != null) {
            target.right = root.left;
            turn(root.left, target.right);
        }
        if (root.right != null) {
            target.left = root.right;
            turn(root.right, target.left);
        }

    }
}
