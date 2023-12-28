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
    int res=Integer.MIN_VALUE;
    // int solve(TreeNode root)
    // {
    //     if(root==null)
    //     return 0;
    //     int l=solve(root.left);
    //     int r=solve(root.right);
    //     int temp=root.val + Math.max(Math.max(l,r), 0);
    //     int ans=Math.max(temp, root.val+l+r);
    //     res=Math.max(res, ans);
    //     return temp;
    // }

    //Sandeep's method'
    int solve(TreeNode root){
        if(root==null)
        return 0;
        int l=solve(root.left);
        int r=solve(root.right);
        res=Math.max(res, (root.val + Math.max(l,0) + Math.max(r,0) ) );
        return root.val + Math.max( Math.max(l,0), Math.max(r,0));
    }
    public int maxPathSum(TreeNode root) 
    {
        if(root==null)
        return 0;
        // solve(root);
        // return res;
        solve(root);
        return res;
    }
}
