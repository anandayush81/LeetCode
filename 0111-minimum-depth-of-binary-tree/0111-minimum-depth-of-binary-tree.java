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
    // int maxi=(int)1e9;
    private int solve(TreeNode root){
        if(root==null) return (int)1e9;
        if(root.left==null && root.right==null)
        return 1;
        int l=solve(root.left);
        int r=solve(root.right);
        return 1+Math.min(l,r);
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return solve(root);
    }
}