/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int length = 0;
    int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ll = diameter(root.left);
        int rl = diameter(root.right);
        length = Math.max(length, ll+rl);
        return Math.max(ll,rl) + 1; 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return length;
    }
}