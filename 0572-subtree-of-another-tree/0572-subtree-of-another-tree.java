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
    private boolean issame(TreeNode root, TreeNode subroot){
        if(root==null && subroot==null) return true;
        if(root==null || subroot==null) return false;
        if( root.val==subroot.val && issame(root.left, subroot.left)
        && issame(root.right, subroot.right) )
        return true;
        return false;

    }
    private boolean inorder(TreeNode root, TreeNode subroot){
        if(root==null) return false;
        if(root.val==subroot.val && issame(root, subroot)) return true;
        if(inorder(root.left, subroot) || inorder(root.right, subroot)) return true;
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return inorder(root, subRoot);
        
    }
}