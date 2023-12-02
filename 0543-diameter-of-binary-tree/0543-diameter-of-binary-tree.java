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
class Solution 
{
    int ans=-1;
    int height(TreeNode root)
    {
        if(root==null)
        return -1;
        int l=height(root.left);
        int r=height(root.right);
        ans=Math.max(ans,(l+r+2));
        return 1+Math.max(l,r);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        height(root);
        return ans;
        
    }





    //Aditya Verma technique
    // int res=Integer.MIN_VALUE; 
    // private int solve(TreeNode root){
    //     if(root==null) return 0;
    //     int l=solve(root.left);
    //     int r=solve(root.right);
        
    //     int temp=1+Math.max(l,r);
    //     int ans=Math.max(temp, 1+l+r);
    //     res=Math.max(ans, res);
    //     return temp;

    // }
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if(root==null)
    //     return 0;
    //     solve(root);
    //     return res-1;
        
    // }
}