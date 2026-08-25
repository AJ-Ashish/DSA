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

// Approach 1 -> DFS 
// TC = O(n)  
// SC = O(1) auxilary space and O(depth) system stack 
class Solution {
    int ans = 0;
    int maxDepth = Integer.MIN_VALUE;
    void dfs(TreeNode root, int depth) { 
        if(root == null) {
            return;
        }
        if(depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);

    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return ans;
    }
}

// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         int ans = root.val;
//         queue.offer(root);
//         boolean flag = false;

//         while(!queue.isEmpty()) {
//             int size = queue.size();

//             for(int i=0; i<size; i++) {
//                 TreeNode curr = queue.poll();
//                 if(i == 0) {
//                     ans = curr.val;
//                 }
//                 if(curr.left != null) {
//                     queue.offer(curr.left);
//                 }
//                 if(curr.right != null) {
//                     queue.offer(curr.right);
//                 }
//             }
//         }
//         return ans;


//     }
// }