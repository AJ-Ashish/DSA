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
//  TC = O(logn) && SC = O(h)
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {

//         if(root == null || root.val == val) {
//             return root;
//         }
//         if(val < root.val) {
//             return searchBST(root.left,val);
//         }
//         return searchBST(root.right,val);
//     }
// }

// TC = O(logn) SC + O(1)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        while(root != null) {
            if(root.val == val) {
                return root;
            }
            if (val < root.val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }
}