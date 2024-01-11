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

//optimised solution

class Solution {
    int maxHeight = Integer.MIN_VALUE;
    int height = 0;
    int maxSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        inorderDFS(root,height);
        return maxSum;
    }
    public void inorderDFS(TreeNode root, int height){
        if(root == null) return;
        height += 1;
        inorderDFS(root.left,height);
        if(root.left == null && root.right==null){ // Node is leaf
            if(maxHeight < height){
                maxHeight = height;
                maxSum = root.val;
            }
            else if(maxHeight == height){
                maxSum = maxSum + root.val;
            }
        }
        inorderDFS(root.right,height);
    }
}

//////////////////////////////////////////////
// class Solution {
//     private int height(TreeNode root){
//         if(root==null) return 0;
//         int l=height(root.left);
//         int r=height(root.right);
//         return 1+Math.max(l,r);
//     }
//     private int bfs(TreeNode root, int ht){
//         Queue<TreeNode>q=new LinkedList<>();
//         q.add(root);
//         int h=0, sum=0;
//         while(!q.isEmpty()){
//             ++h;
//             int n=q.size();
//             for(int i=0;i<n;i++){
//                 TreeNode node=q.poll();
//                 if(h==ht){
//                     sum+=node.val;
//                 }
//                 if(node.left!=null) q.add(node.left);
//                 if(node.right!=null) q.add(node.right);
//             }
//         }
//         return sum;
//     }
//     public int deepestLeavesSum(TreeNode root) {
//         if(root==null) return 0;
//         int ht=height(root);
//         return bfs(root, ht);
        
//     }
// }