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

//  class Solution {
//     int dfs(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         if(root.left == null && root.right == null) {
//             return 1;
//         }
//         int leftDepth = (root.left != null) ? dfs(root.left) :  Integer.MAX_VALUE;
//         int rightDepth = (root.right != null) ? dfs(root.right) :  Integer.MAX_VALUE;
//         return Math.min(leftDepth,rightDepth)+1;
//     } 
//     public int minDepth(TreeNode root) {
//         return dfs(root);
//     }
// }
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) {
                    return depth;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return -1;
    }
}