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
    Map<Integer, Integer>map;
    private void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        traverse(root.right);
    }
    public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        // if(root==null) return new int[];
        traverse(root);
        int maxFreq=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            maxFreq=Math.max(maxFreq, map.get(key));
        }
        List<Integer>ans=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                ans.add(key);
            }
        }
        int n=ans.size();
        int k=0;
        int ans2[]=new int[n];
        for(int x:ans){
            ans2[k++]=x;
        }
        return ans2;
        
        

    }
}