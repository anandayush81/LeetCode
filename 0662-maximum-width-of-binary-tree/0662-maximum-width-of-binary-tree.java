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

class Node{
    TreeNode node;
    int rowIdx;
    Node(TreeNode node, int rowIdx){
        this.node=node;
        this.rowIdx=rowIdx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(root,0));
        int maxi=0;
        while(!q.isEmpty()){
            int size=q.size();
            int start=0,end=0;
            for(int i=0;i<size;i++){
                Node n=q.remove();
                TreeNode cur=n.node;
                int index=n.rowIdx;
                
                if(i==0) start=index;
                if(i==size-1) end=index;

                if(cur.left!=null)
                q.add(new Node(cur.left, 2*index));
                if(cur.right!=null)
                q.add(new Node(cur.right, 2*index+1));
            }
            maxi=Math.max(maxi, end-start+1);
        }
        return maxi;
        
    }
}