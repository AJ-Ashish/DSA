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
    TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) {
            return node;
        }
        if(node.val < root.val){
            root.left = insertNode(root.left, node);
        }else if (node.val > root.val ){
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1; i<preorder.length; i++) {
            insertNode(root,new TreeNode(preorder[i]));
        }
        return root;
    }
}