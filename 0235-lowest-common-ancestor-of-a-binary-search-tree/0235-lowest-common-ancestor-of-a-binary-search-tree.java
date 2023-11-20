/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root.val<p.val && root.val<q.val) return solve(root.right, p,q);
        else if(root.val>p.val && root.val>q.val) return solve(root.left, p,q);
        else return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        return solve(root, p,q);
        
    }
}