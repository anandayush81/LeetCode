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

 //O(n^2) Solution

class Solution {
    int total = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        helper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return total;
    }

    void helper(TreeNode root, int sum, long curr) {
        if(root == null) return;
        curr += root.val;
        if(curr == sum) total++;
        helper(root.left, sum, curr);
        helper(root.right, sum, curr);
    }
}

//map method
// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null)
//             return 0;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
//         return helper(root, 0, targetSum, map);
//     }
    
//     public int helper(TreeNode root, int current, int target, Map<Integer, Integer> map) {
//         if(root == null)
//             return 0;
        
//         current += root.val;
//         int count = 0;
        
//         count += map.getOrDefault(current - target, 0);
//         map.put(current, map.getOrDefault(current, 0) + 1);
        
//         count += helper(root.left, current, target, map);
//         count += helper(root.right, current, target, map);
        
//         map.put(current, map.get(current) - 1);
//         return count;
//     }
// }