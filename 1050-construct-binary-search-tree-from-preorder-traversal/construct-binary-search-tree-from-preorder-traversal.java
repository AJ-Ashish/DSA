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

        // BRUTE FORCE 
// class Solution {
//     TreeNode insertNode(TreeNode root, TreeNode node) {
//         if(root == null) {
//             return node;
//         }
//         if(node.val < root.val){
//             root.left = insertNode(root.left, node);
//         }else if (node.val > root.val ){
//             root.right = insertNode(root.right, node);
//         }
//         return root;
//     }

//     public TreeNode bstFromPreorder(int[] preorder) {
//         TreeNode root = new TreeNode(preorder[0]);

//         for(int i=1; i<preorder.length; i++) {
//             insertNode(root,new TreeNode(preorder[i]));
//         }
//         return root;
//     }
// }

                    // Optimal solution 
class Solution {
    int index = 0;
    TreeNode buildBST(int[] preorder, int bound) {

        if(index >= preorder.length || preorder[index] > bound ) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;

        root.left = buildBST(preorder, root.val);
        root.right = buildBST(preorder, bound);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}