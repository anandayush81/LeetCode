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
    private boolean check(TreeNode root, long mini, long maxi){
        if(root==null) return true;

        // if(root.val<mini || root.val>maxi) return false;

        // if( (check(root.left,mini,root.val-1) && check(root.right,root.val+1,maxi) )) return true;

        // return false;


        // if(root.val>=mini && root.val<=maxi
        // && check(root.left,mini,root.val-1)
        // && check(root.right,root.val+1,maxi))
        // return true;
        // return false;

        if(root.val>mini && root.val<maxi
        && check(root.left,mini,root.val)
        && check(root.right,root.val,maxi))
        return true;
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        if(root ==null) return false;
        // int mini=Integer.MIN_VALUE, maxi=Integer.MAX_VALUE;
        long mini=Long.MIN_VALUE, maxi=Long.MAX_VALUE;
        return check(root, mini, maxi);
    }
}