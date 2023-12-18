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
// class Solution {
//     public String tree2str(TreeNode root) {
        
//     }
// }

class Solution {
    // static String str = "";
    // str.append('(');
    // str.append(')');
    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode root) {
        // str="";
        help(root);
        return str.toString();
    }
    
    public  void help(TreeNode root){
        if(root==null) return;
        str.append(root.val);
        if(root.left != null || root.right!=null){
            str.append('(');
            help(root.left);
            str.append(')');
        }
        if(root.right!=null){
            str.append('(');
            help(root.right);
            str.append(')');
        }
    }
}