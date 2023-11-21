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
    private boolean solve(TreeNode root, int k, int sum){
        if(root==null) return false;
        sum+=root.val;
        // if(root.left==null && root.right==null){
        //     if(sum==k) return true;
        //     return false;
        // }
        if(root.left==null && root.right==null && sum==k) 
        return true;
        
        if(solve(root.left,k,sum ) || solve(root.right,k,sum))
        return true;
        return false;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return solve(root, targetSum,0);        
    }
}