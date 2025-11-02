class Solution {
    public int solve(int nums[], int dp[][], int target, int idx, int sum){
        if(sum<=0){
            if(sum==0) return 1;
            return 0;
        }
        if(idx>=nums.length || sum<0) return 0;
        if(dp[idx][sum]!=-1) return dp[idx][sum];

        int take = solve(nums, dp, target, 0, sum-nums[idx]);
        int donttake=solve(nums, dp, target, idx+1, sum);
        int ans=take+donttake;
        
        // int ans=0;
        // for(int i=idx;i<nums.length;i++){
        //     ans+=solve(nums, dp, target, 0, sum-nums[i]);
        // }
        return dp[idx][sum]=ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[][]=new int[n+1][target+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        int ans=  solve(nums, dp, target, 0, target);
        // System.out.println(Arrays.toString(dp));
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=target;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
        
    }
}