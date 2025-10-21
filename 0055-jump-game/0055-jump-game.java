// class Solution {
//     public boolean solve(int nums[], int idx){
//         if(idx>=(nums.length-1)) return true;
//         if(nums[idx]==0) return false;
//         for(int i=1;i<=nums[idx];i++){
//             if(solve(nums, idx+i)==true)
//             return true;
//         }
//         return false;
//     }
//     public boolean canJump(int[] nums) {
//         return solve(nums,0);
        
//     }
// }

//memoization

//here dp[i] indicates if it's possible to reach the last index from the index i
//And since we're returning the final result as dp[0]- the final result indicates if it is possible to reach the last index from 0th index


class Solution {
    Boolean dp[];
    private boolean solve(int nums[], int idx, int n){
        if(idx>=n) return false;
        if(idx==n-1) return true;
        if(nums[idx]==0) return false;
        if(dp[idx]!=null) return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,idx+i,n)) return dp[idx]=true;
        }
        return dp[idx]=false;
    }
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        return solve(nums, 0, nums.length);

    }
}