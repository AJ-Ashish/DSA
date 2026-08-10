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


                // Brute Force O(N2)
// class Solution {
//     int ans = 0;
//     int findSum(TreeNode root, int count[]) {
//         if(root == null) {
//             return 0;
//         }
//         count[0]++;
//         int leftSum = findSum(root.left, count);
//         int rightSum = findSum(root.right, count);

//         return root.val + leftSum + rightSum;
//     }
//     public int averageOfSubtree(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         int count[] = {0};
//         int sum = findSum(root,count);
//         if(root.val == sum/count[0]) {
//             ans++;
//         }
//         averageOfSubtree(root.left);
//         averageOfSubtree(root.right);
//         return ans;
//     }
// }

                        // Optimal solution

// tc and sc = O(n)
class Pair {
    int sum;
    int count;
    Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
    
class Solution {    
    int ans;

    Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair(0,0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        if(root.val == sum/count) {
            ans++;
        }

        return new Pair(sum,count);
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

}