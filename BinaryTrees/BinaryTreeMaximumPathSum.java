package BinaryTrees;

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
    int maxSum; 
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }
    public int findMaxPath(TreeNode root){
        if(root==null) return 0;
        int lc = Math.max(findMaxPath(root.left), 0);
        int rc = Math.max(findMaxPath(root.right), 0);
        maxSum = Math.max(maxSum, root.val+lc+rc);
        return root.val+Math.max(lc, rc);
    }
}
