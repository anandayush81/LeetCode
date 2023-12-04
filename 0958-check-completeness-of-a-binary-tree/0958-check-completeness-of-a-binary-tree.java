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
//     private int inorder(TreeNode root){
//         if(root==null) return 0;
//         int l=inorder(root.left);
//         int r=inorder(root.right);
//         return 1+l+r;
//     }
//     public boolean isCompleteTree(TreeNode root) {
//         int totalNodes=inorder(root);
//         Queue<TreeNode>q=new LinkedList<>();
//         int cnt=1;
//         q.add(root);
//         while(!q.isEmpty()){
//             TreeNode temp=q.remove();
//             if(temp.left==null) break; else {q.add(temp.left); cnt++;}
//             if(temp.right==null) break; else {q.add(temp.right); cnt++;}
//         }
//         return (cnt==totalNodes);
        
//     }
// }

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        boolean past=false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            if(temp==null) past=true;
            else{
                if(past==true)
                return false;

                q.add(temp.left);
                q.add(temp.right);
            }
            
        }
        return true;        
    }
}