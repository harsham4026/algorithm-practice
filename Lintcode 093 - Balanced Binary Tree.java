Lintcode 093 - Balanced Binary Tree.java
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return MaxDepth(root) > -1;
    }
    
    //判断左右子树返回的Max Depth相差是否大于1
    private int MaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return -1;
        } 
        if (left < 0 || right < 0) {
            return -1;
        }
        return Math.max(left, right) + 1;
        
        
    }
}
