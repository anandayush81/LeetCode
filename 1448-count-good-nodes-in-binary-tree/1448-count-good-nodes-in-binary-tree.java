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
    int cnt=0;
    private boolean isIncreasing(List<Integer>temp){        
        int last=temp.get(temp.size()-1);
        for(int i=0;i<temp.size()-1;i++){
            if(temp.get(i)>last) return false;
        }
        return true;
    }
    // private void printt(List<Integer>temp){
    //     for(int i=0;i<temp.size();i++){
    //         System.out.print(temp.get(i)+" ");
    //     }
    //     System.out.println();
    // }
    private void solve(TreeNode root, List<Integer>temp){
        if(root==null) return;
        temp.add(root.val);
        if(isIncreasing(temp)) {
            // printt(temp);
            cnt++;
        }
        solve(root.left, temp);
        solve(root.right, temp);
        temp.remove(temp.size()-1);

    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        List<Integer>temp=new ArrayList<>();
        solve(root, temp);
        return cnt;
        
    }
}