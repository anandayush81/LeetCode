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

//Recursive BFS

class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        run(root, 0, ret);
        return ret;
    }
    
    private void run(TreeNode root, int level, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        if (level == ret.size()) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(root.val);
        run(root.left, level + 1, ret);
        run(root.right, level + 1, ret);
    }
}

// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {

//         List<List<Integer>> ans=new ArrayList<>();
//         if(root==null) return ans;
//         Queue<TreeNode>q=new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()){
//             int size=q.size();
//             List<Integer>temp=new ArrayList<>();
//             for(int i=0;i<size;i++){
//                 TreeNode t=q.remove();
//                 temp.add(t.val);
//                 if(t.left!=null) q.add(t.left);
//                 if(t.right!=null) q.add(t.right);
//             }
//             ans.add(new ArrayList<>(temp));
            
//         }
//         return ans;
//     }
// }