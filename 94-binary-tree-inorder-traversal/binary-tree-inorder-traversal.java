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
//     public void helper(TreeNode root, List<Integer> list) {
//         if(root == null) {
//             return;
//         }
        
//         helper(root.left,list);
//         list.add(root.val);
//         helper(root.right,list);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         helper(root, list);
//         return list;
       
//     }
// }
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();


        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode currLeft = curr.left;

                while(currLeft.right != null) {
                    currLeft = currLeft.right;
                }
                currLeft.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }

        }
        return list;
    }
}