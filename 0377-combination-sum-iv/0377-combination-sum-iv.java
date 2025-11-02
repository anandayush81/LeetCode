class Solution {
    public int solve(int nums[], int dp[][], int target, int idx, int sum){
        if(sum<=0){
            if(sum==0) return 1;
            return 0;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        int ans=0;
        for(int i=idx;i<nums.length;i++){
            ans+=solve(nums, dp, target, 0, sum-nums[i]);
        }
        return dp[idx][sum]=ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[][]=new int[n+1][target+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return solve(nums, dp, target, 0, target);
        
    }
}