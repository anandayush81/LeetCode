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
class Pair{
    TreeNode node;
    int time;
    public Pair(TreeNode nn, int tt){
        node=nn;
        time=tt;
    }
}
class Solution {
    HashMap<TreeNode, TreeNode>map=new HashMap<>();
    private TreeNode search(TreeNode root, int k){
        if(root==null) return null;
        if(root.val==k) return root;
        TreeNode l=search(root.left, k);
        TreeNode r=search(root.right, k);
        if(l==null && r==null) return null;
        else if(l==null && r!=null) return r;
        else return l;
    }
    private void getparent(TreeNode root){
        if(root==null) return;
        if(root.left!=null) 
        map.put(root.left, root);
        if(root.right!=null)
        map.put(root.right, root);
        getparent(root.left);
        getparent(root.right);
        
    }
    public int amountOfTime(TreeNode root, int start) {

        if(root==null) return 0;
        int ans=Integer.MIN_VALUE;
        TreeNode s=search(root, start);
        getparent(root);
        Queue<Pair>q=new LinkedList<>();
        HashSet<TreeNode>set=new HashSet<>();
        q.add(new Pair(s,0));
        set.add(s);
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int t=p.time;
            ans=Math.max(ans,t);
            if(node.left!=null && !set.contains(node.left)){ //left child
                q.add(new Pair(node.left, t+1));
                set.add(node.left);
            }
            
            if(node.right!=null && !set.contains(node.right)){ //right child
                q.add(new Pair(node.right, t+1));
                set.add(node.right);
            }
            
            if(map.containsKey(node) && !set.contains(map.get(node))){ //parent
                q.add(new Pair(map.get(node), t+1));
                set.add(map.get(node));
            }
        }
        return ans;
    }
}