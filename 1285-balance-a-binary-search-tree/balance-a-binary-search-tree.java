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
    void inorder(TreeNode root,List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return solve(0, list.size()-1, list);
    }
    TreeNode solve(int left, int right,  List<Integer> list) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(left, mid-1, list);
        root.right = solve(mid+1, right, list);
        return root;

    }
} 