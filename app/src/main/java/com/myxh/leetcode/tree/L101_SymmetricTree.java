package com.myxh.leetcode.tree;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 *      1
 *    /   \
 *   2    2
 *  / \  / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 *  1
 * / \
 * 2  2
 * \   \
 * 3   3
 */
public class L101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 39.5 MB, less than 52.93% of Java online submissions for Symmetric Tree.
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isChildSymmetric(root.left, root.right);
    }

    public static boolean isChildSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        boolean isSame = leftNode.val == rightNode.val;
        isSame &= isChildSymmetric(leftNode.left, rightNode.right);
        isSame &= isChildSymmetric(leftNode.right, rightNode.left);
        return isSame;
    }

    /**
     * 高赞答案-非递归版本
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!stack.empty()) {
            if (stack.size() % 2 != 0) {
                return false;
            }
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) {
                return false;
            }

            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }
}
