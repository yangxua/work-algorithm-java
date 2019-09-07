package com.xuyang.algorithm.tree;

import com.xuyang.algorithm.common.TreeNode;

import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 20:32
 * @Description:
 */
public class Trees {

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return ;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return ;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 前序遍历（非递归）
     */
    public void preOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.println(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历（非递归）
     */
    public void inOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    /**
     * 后续遍历（非递归）
     */
    public void postOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode c = null;
        TreeNode h = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(h);

        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                System.out.println(stack.pop().val);
                h = c;
            }
        }
    }

}