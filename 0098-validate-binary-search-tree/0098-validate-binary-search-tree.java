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


 //one case of 
 //  -2147483647
 //   /
 //  -2147483647
 //This case is tricky and edge case
// class Solution {
//     private boolean check(TreeNode root, long mini, long maxi){
//         if(root==null) return true;

//         // if(root.val<mini || root.val>maxi) return false;
//         // if( (check(root.left,mini,root.val-1) && check(root.right,root.val+1,maxi) )) return true;
//         // return false;


//         // if(root.val>=mini && root.val<=maxi
//         // && check(root.left,mini,root.val-1)
//         // && check(root.right,root.val+1,maxi))
//         // return true;
//         // return false;

//         if(root.val>mini && root.val<maxi
//         && check(root.left,mini,root.val)
//         && check(root.right,root.val,maxi))
//         return true;
//         return false;
//     }
//     public boolean isValidBST(TreeNode root) {
//         if(root ==null) return false;
//         // int mini=Integer.MIN_VALUE, maxi=Integer.MAX_VALUE;
//         long mini=Long.MIN_VALUE, maxi=Long.MAX_VALUE;
//         return check(root, mini, maxi);
//     }
// }

//another good solution
// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, null, null);
//     }
//     boolean helper(TreeNode root, Integer min, Integer max) {
//         if (root == null)
//             return true;  
//         if ((min != null && root.val <= min) || (max != null && root.val >= max))
//             return false; 
//         return helper(root.left, min, root.val) && helper(root.right, root.val, max);
//     }
// }

//using prev in bst inorder traversal
public class Solution {
    TreeNode prev;
    private boolean inorder(TreeNode root) {
        if (root == null)
            return true;
        if(inorder(root.left)==false) return false;
        if(prev!=null){
            if(root.val<=prev.val) return false;
        }
        prev=root;
        if(inorder(root.right)==false) return false;
        return true;
        
    }
    public boolean isValidBST(TreeNode root) {
        prev=null;
        return inorder(root);
    }
    
}