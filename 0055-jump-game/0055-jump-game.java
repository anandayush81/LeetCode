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

class Solution {
    public boolean solve(boolean dp[], int nums[], int idx){
        if(idx==(nums.length-1)) return dp[idx]= true;
        if(nums[idx]==0) dp[idx]= false;
        for(int i=1;i<=Math.min(nums.length, nums[idx]);i++){
            if(solve(dp, nums, idx+i)==true)
            return dp[idx]=true;
        }
        return dp[idx]=false;
    }
    public boolean canJump(int[] nums) {
        boolean dp[]=new boolean[nums.length];
        Arrays.fill(dp, false);
        return solve(dp, nums,0);
        
    }
}