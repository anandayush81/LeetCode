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
    
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         if (t1 == null && t2 == null) return null;
//         if (t1 == null) return t2;
//         if (t2 == null) return t1;
        
//         TreeNode new_node = new TreeNode(t1.val + t2.val);
        
//         new_node.left = mergeTrees(t1.left, t2.left);
//         new_node.right = mergeTrees(t1.right, t2.right);
        
//         return new_node;
//     }
// } 

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}


// class Solution {
//     public TreeNode solve(ArrayList<Integer> A) {
//         Queue<TreeNode>q=new LinkedList<>();
//         TreeNode root=new TreeNode(A.get(0));
//         q.add(root);
//         int arrlimit=((A.size())/2)-1;
//         int i=0;
//         while(!q.isEmpty()&&(i<=arrlimit))
//         {
//             TreeNode f=q.poll();
//             if(A.get(2*i+1)==-1)
//             f.left=null;
//             else
//             {
//                 f.left=new TreeNode(A.get(2*i+1));
//                 q.add(f.left);
//             }
//             if(A.get(2*i+2)==-1)
//             f.right=null;
//             else
//             {
//                 f.right=new TreeNode(A.get(2*i+2));
//                 q.add(f.right);
//             }
//             i++;
//         }
//        return root;
//     }
    
//     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//         if(root1==null) return root2;
//         if(root2==null) return root1;
//         Queue<TreeNode>q1=new LinkedList<>();
//         Queue<TreeNode>q2=new LinkedList<>();

//         q1.add(root1);
//         q2.add(root2);

//         List<TreeNode>al=new ArrayList<>();
//         // al.add(new TreeNode(root1.val+root2.val, null, null));

//         while(!q1.isEmpty() || !q2.isEmpty()){
//             TreeNode n1=q1.poll(), n2=q2.poll();
//             if(n1!=null && n2!=null) {
//                 q1.add(n1.left); q1.add(n1.right);
//                 q2.add(n2.left); q2.add(n2.right);
//                 al.add(new TreeNode(n1.val + n2.val, null, null));
//             }
//             else if(n1==null && n2!=null){
//                 q2.add(n2.left); q2.add(n2.right);
//                 al.add(new TreeNode( n2.val, null, null));
//             } 
//             else if(n1!=null && n2==null){
//                 q1.add(n1.left); q1.add(n1.right);
//                 al.add(new TreeNode( n1.val, null, null));
//             } 
//         }
//         int n=al.size();
//         // System.out.println(al.);
//         Queue<TreeNode>q=new LinkedList<>();
//         q.add(al.get(0));
//         int i=0;
//         while(i<(n-2)/2){
//             TreeNode temp=q.poll();
//             if(temp==null){
//                 i++;
//                 continue;
//             }
//             temp.left=al.get(2*i+1);
//             temp.right=al.get(2*i+2);
//             q.add(temp.left); i++;
//             q.add(temp.right); i++;
//             i++;
//         }
//         return al.get(0);


//     }
// }