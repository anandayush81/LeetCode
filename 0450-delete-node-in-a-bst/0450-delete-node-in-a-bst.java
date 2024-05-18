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
    public TreeNode deleteNode(TreeNode root, int key) {
        // if(root==null || (root.left==null && root.right==null)) return root;
        //search if this node is present with it's parent
        TreeNode parent=null, cur=null, newcur=null, del=null; 
        cur=root;
        while(cur!=null && cur.val!=key)
        {
            parent=cur;
            if(key>cur.val)
            cur=cur.right;
            else if(key<cur.val)
            cur=cur.left;
        }
        if(cur==null)
        return root;
        else
        del=cur;
        //Check if at most 1 child
        if(del.left==null || del.right==null)
        {
            newcur=null;
            if(del.left==null)
            newcur=del.right;
            else
            newcur=del.left;

            //edge case when we have to delete the root of the tree
            //in this case, if the tree is skewed, we'll just return the second node from the root of the tree'
            if(parent==null)
            return newcur;


            if(del==parent.left)
            parent.left=newcur;
            else
            parent.right=newcur;

        }
        //if 2 children
        else
        {
            //FInd Inorder Successor (Leftmost node of RST)
            TreeNode ios=null, prevOfIos=null;
            cur=del.right;
            while(cur.left!=null)
            {
                prevOfIos=cur;
                cur=cur.left;
            }
            ios=cur;
            //since inorder successor is the leftmost ode of the Right sub tree, it doesn't mena the ios cant have a RST of its' own
            //And since the ios can have a RST of its's own, we need to attach that to correct place
            //so we check if the ios has a parent or not
            //if it has a parent attach the rst of ios to parent's left coz the ios is at the left of the parent
            //if no parent attach attach that to the right of dnode to be deleted
            if(prevOfIos!=null)
            {
                prevOfIos.left=ios.right;
            }
            else
            del.right=ios.right;

            del.val=ios.val;
        }
        return root;

        
    }
}